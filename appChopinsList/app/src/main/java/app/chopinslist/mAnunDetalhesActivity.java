package app.chopinslist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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
                Intent it = new Intent(mAnunDetalhesActivity.this, mAnunAttActivity.class);
                it.putExtra("anun", anun);
                it.putExtra("usu", u);
                startActivityForResult(it, 1);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context ctx = v.getContext();

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação").setMessage("Tem certeza que deseja excluir este anúncio?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent it = new Intent();
                        it.putExtra("anun7", anun);
                        setResult(1, it);
                        Toast.makeText(ctx, "anúncio excluído com sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }).setNegativeButton("Cancelar", null).create().show();
            }
        });


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Anuncio mudado = (Anuncio) data.getSerializableExtra("anunmuda");

                tit.setText(mudado.getTitulo());
                desc.setText(mudado.getDesc());

                Intent it = new Intent();
                it.putExtra("anun3", mudado);
                setResult(RESULT_OK, it);
            }
        }
    }
}
