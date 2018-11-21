package app.chopinslist.CRUD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Create extends SQLiteOpenHelper {

    private static final String Nome_db = "DbChopin";//nome do banco
    private static final int Versao_bd = 1;//versao do banco
    private static final String Tabela_user = "Tabela user";//tabela de registros
    private static final String Tabela_anun = "Tabela anun";//tabela de registros


    private static final String Caminho_db = "/data/user/0/app.chopinslist/database/DbChopin";//caminho do banco de dados

    private Context Ccontext;
    private SQLiteDatabase db;

    public Create(Context context) {
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

    public boolean creatTable_users(){
            abredb();
            String creatTable_users = Tabela_user +"("
                    +"LOGIN TEXT,"
                    +"SENHA TEXT)";
            try{
                db.execSQL(creatTable_users);
                return true;
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }finally {
                db.close();
            }
    }

    public boolean creatTable_anun(){
        abredb();
        String creatTable_anun = Tabela_anun +"("
                +"LOGIN TEXT,"
                +"TITULO TEXT,"
                +"DESCRICAO TEXT)";
        try{
            db.execSQL(creatTable_anun);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
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
