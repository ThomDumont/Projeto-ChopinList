package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.chopinslist.Models.Anuncio;
import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class mAnunAttActivity extends AppCompatActivity {

    Button att;
    TextView tit, desc;
    Anuncio anun;
    User u;
    dbHelper db = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_anun_att);

        att = findViewById(R.id.btnATT);
        tit = findViewById(R.id.txt_titulo2);
        desc = findViewById(R.id.txt_descricao2);
        anun = (Anuncio) getIntent().getSerializableExtra("anun");
        u = (User) getIntent().getSerializableExtra("usuario");

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo = tit.getText().toString();
                String descri = desc.getText().toString();
                Anuncio b;
                b = db.buscaAnun(anun);
                b.setTitulo(titulo);
                b.setDesc(descri);
                db.attAnun(anun);
                alert("Anúncio atualizado!!");
                db.closeDB();
            }
        });

    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}

