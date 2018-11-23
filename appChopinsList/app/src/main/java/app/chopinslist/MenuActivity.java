package app.chopinslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.chopinslist.Models.User;

public class MenuActivity extends AppCompatActivity {
    Button btn_anunciar, btn_vAnuncios, btn_mAnuncios, btn_config;
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_anunciar = (Button) findViewById(R.id.btn_anunciar);
        btn_vAnuncios = (Button) findViewById(R.id.btn_vAnuncios);
        btn_mAnuncios = (Button) findViewById(R.id.btn_mAnuncios);
        btn_config = (Button) findViewById(R.id.btn_config);
        u = (User) getIntent().getSerializableExtra("usu");

        btn_anunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AnunciarActivity.class);
                it.putExtra("usuario", u);
                startActivity(it);
            }
        });

        btn_vAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, vAnunciosActivity.class);
                it.putExtra("usuario", u);
                startActivity(it);
            }
        });

     /*   btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, Config.class);
                startActivity(it);
            }
        });*/

        btn_mAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, mAnunciosActivity.class);
                it.putExtra("usuario", u);
                startActivity(it);
            }
        });
    }
}
