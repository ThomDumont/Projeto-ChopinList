package app.chopinslist.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.chopinslist.User;


public class Update extends SQLiteOpenHelper {

    private static final String Nome_db = "DbChopin";//nome do banco
    private static final int Versao_bd = 1;//versao do banco
    private static final String Tabela_user = "Tabela user";//tabela de registros

    private static final String Caminho_db = "/data/user/0/app.chopinslist/database/DbChopin";//caminho do banco de dados

    private Context Ccontext;
    private SQLiteDatabase db;

    public Update(Context context) {
        super(context, Nome_db, null, Versao_bd);
        this.Ccontext= context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insere_user(User u){
        abredb();
        try {
            ContentValues cv = new ContentValues();
            cv.put("LOGIN", u.getLogin());
            cv.put("SENHA", u.getSenha());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
    }

    private void abredb(){
        if(!db.isOpen()){
            db = Ccontext.openOrCreateDatabase(Caminho_db,SQLiteDatabase.OPEN_READWRITE,null);
        }
    }
}
