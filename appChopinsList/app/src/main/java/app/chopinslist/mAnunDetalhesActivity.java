package app.chopinslist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.chopinslist.Models.Anuncio;
import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class mAnunDetalhesActivity extends AppCompatActivity {

    TextView tit,desc;
    Anuncio anun;
    User u;
    Button att, del;

    dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_anun_detalhes);

        del = findViewById(R.id.btn_del);
        att = findViewById(R.id.btn_att);

        tit = findViewById(R.id.textTit);
        desc = findViewById(R.id.textDesc);
        anun = (Anuncio) getIntent().getSerializableExtra("anun");
        u = (User) getIntent().getSerializableExtra("usuario");

        tit.setText(anun.getTitulo());
        desc.setText(anun.getDesc());

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mAnunDetalhesActivity.this, mAnunAttActivity.class);
                intent.putExtra("anun", anun);
                intent.putExtra("usu", u);
                startActivity(intent);
            }
        });
    }
}
