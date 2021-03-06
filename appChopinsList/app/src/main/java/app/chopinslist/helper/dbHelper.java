package app.chopinslist.helper;
import app.chopinslist.Models.Anuncio;
import app.chopinslist.Models.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {
    private static final String nome = "ChopinsList.db";
    private static  final int Versao = 1;

    //nome das tabelas
    private static final String  user = "Usuarios";
    private static final String anun = "Anuncios";
    private static final String junta = "UsersAnun";

    //em comum
    private static final String id = "id";

    //tabela anuncio
    private static final String tit = "titulo";
    private static final String desc = "descricao";


    //tabela usuario
    private static final String log = "login";
    private static final String sen = "senha";
    private static final String ema = "email";
    private static final String nom = "nome";
    private static final String tele = "telefone";

    //tabela junta
    private static final String id_user = "userID";
    private static final String id_anun = "anunID";



    private static final String tabela_usuarios = "CREATE TABLE "
            + user + "(" + id + " INTEGER PRIMARY KEY," + log
            + " TEXT," + sen + " TEXT," + ema + " TEXT," + nom + " TEXT," + tele + " TEXT)";

    private static final String tabela_anuncios = "CREATE TABLE "
            + anun + "(" + id + " INTEGER PRIMARY KEY," + tit
            + " TEXT," + desc + " TEXT)";


    private static final String tabela_junta = "CREATE TABLE "
            + junta + "(" + id + " INTEGER PRIMARY KEY," + id_user
            + " INTEGER," + id_anun + " INTEGER)";


    public dbHelper( Context context) {
        super(context, nome, null, Versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabela_usuarios);
        db.execSQL(tabela_anuncios);
        db.execSQL(tabela_junta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createUsuarios(User usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(log, usuario.getLogin());
        values.put(sen, usuario.getSenha());
        values.put(ema, usuario.getEmail());
        values.put(nom, usuario.getNome());
        values.put(tele, usuario.getTelefone());
        db.insert(user, null, values);

    }

    public boolean verificaUsuario(User u) {
        SQLiteDatabase db = this.getReadableDatabase();

        String busca = "SELECT * FROM " + user + " WHERE "
                + log + " = '" + u.getLogin() + "' AND " + sen + " = '" + u.getSenha() +"'" ;

        Cursor c = db.rawQuery(busca, null);

        if(c!=null && c.getCount()>0){
            c.close();
            return true;
        }
        else{
            return false;
        }
    }

    public User buscaUsuario(User q) {
        SQLiteDatabase db = this.getReadableDatabase();

        String busca = "SELECT * FROM " + user + " WHERE "
                + log + " = '" + q.getLogin() + "' AND " + sen + " = '" + q.getSenha() +"'" ;


        Cursor c = db.rawQuery(busca, null);

        if(c != null) {
            c.moveToFirst();
        }

        User w = new User();
        w.setId(c.getInt(c.getColumnIndex(id)));
        w.setLogin(c.getString(c.getColumnIndex(log)));
        w.setSenha(c.getString(c.getColumnIndex(sen)));
        w.setEmail(c.getString(c.getColumnIndex(ema)));
        w.setNome(c.getString(c.getColumnIndex(nom)));
        w.setTelefone(c.getString(c.getColumnIndex(tele)));
        c.close();

        return w;
    }

    public Anuncio buscaAnun(Anuncio a) {
        SQLiteDatabase db = this.getReadableDatabase();

        String busca = "SELECT * FROM " + anun + " WHERE "
                + tit + " = '" + a.getTitulo() + "' AND " + desc + " = '" + a.getDesc() +"'" ;


        Cursor c = db.rawQuery(busca, null);

        if(c != null) {
            c.moveToFirst();
        }

        Anuncio w = new Anuncio();
        w.setId(c.getInt(c.getColumnIndex(id)));
        w.setTitulo(c.getString(c.getColumnIndex(tit)));
        w.setDesc(c.getString(c.getColumnIndex(desc)));
        c.close();

        return w;
    }


    public long createAnuncio(Anuncio Anun) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tit, Anun.getTitulo());
        values.put(desc, Anun.getDesc());

        return db.insert(anun, null, values);
    }

    public List<Anuncio> getallAnuncios() {
        List<Anuncio> todos = new ArrayList<>();
        String pegatodos = "SELECT * FROM " + anun;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(pegatodos, null);

        if (c.moveToFirst()) {
            do {
                Anuncio w = new Anuncio();
                w.setId(c.getInt((c.getColumnIndex(id))));
                w.setTitulo(c.getString(c.getColumnIndex(tit)));
                w.setDesc(c.getString(c.getColumnIndex(desc)));
                todos.add(w);
            } while (c.moveToNext());
        }
        c.close();
        return todos;
    }

    public void attAnun(Anuncio a) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tit, a.getTitulo());
        values.put(desc, a.getDesc());

        db.update(anun, values, id + " = " + a.getId(),null);
    }

    public void createJunta(User u, long idAnun) {
        SQLiteDatabase db = this.getReadableDatabase();

        User w = buscaUsuario(u);

        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(id_user, w.getId());
        values.put(id_anun, idAnun);

        db.insert(junta, null, values);

    }

    public List<Anuncio> buscaAnunUsu(User u) {
        User usucompleto = buscaUsuario(u);
        List<Anuncio> todos = new ArrayList<>();
        ArrayList idAnuns = new ArrayList<>();
        String pegaIdAnun = "SELECT * FROM " + junta + " WHERE " +
                id_user + " = " + usucompleto.getId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(pegaIdAnun, null);

        if (c.moveToFirst()) {
            do {
                idAnuns.add(c.getInt(c.getColumnIndex(id_anun)));
            } while (c.moveToNext());
        }

        pegaIdAnun = "SELECT * FROM " + anun + " WHERE " + id + "= ?";

        for (int i = 0; i < idAnuns.size(); i++){
            Cursor w = db.rawQuery(pegaIdAnun, new String[]{String.valueOf(idAnuns.get(i))});
            if (w != null) {
                w.moveToFirst();
                Anuncio a = new Anuncio();
                a.setId(w.getInt(w.getColumnIndex(id)));
                a.setTitulo(w.getString(w.getColumnIndex(tit)));
                a.setDesc(w.getString(w.getColumnIndex(desc)));
                todos.add(a);
                w.close();
            }
        }
        c.close();

        return todos;
    }

    public void delAnun(Anuncio a){
        Anuncio completo = buscaAnun(a);
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(anun, id + " = ?",
                new String[] {String.valueOf(completo.getId())});
        db.delete(junta, id_anun + " = ?",
                new String[] {String.valueOf(completo.getId())});
    }


    public void closeDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
