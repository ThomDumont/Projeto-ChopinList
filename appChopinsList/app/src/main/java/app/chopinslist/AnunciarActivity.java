package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.chopinslist.Models.Anuncio;
import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class AnunciarActivity extends AppCompatActivity {

    EditText txt_titulo, txt_descricao;
    Button btnAnunc;
    dbHelper db = new dbHelper(this);
    User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar);

        txt_titulo = findViewById(R.id.txt_titulo2);
        txt_descricao = findViewById(R.id.txt_descricao2);
        btnAnunc = findViewById(R.id.btnATT);
        u  = (User) getIntent().getSerializableExtra("usuario");

        btnAnunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tit = txt_titulo.getText().toString();
                String desc = txt_descricao.getText().toString();
                Anuncio a = new Anuncio(tit,desc);
                long w = db.createAnuncio(a);
                db.createJunta(u, w);
                alert("Anúncio postado!!");
                finish();
                db.closeDB();
            }
        });
        
    }


    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}
