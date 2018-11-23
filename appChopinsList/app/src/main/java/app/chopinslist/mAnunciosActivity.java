package app.chopinslist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.chopinslist.Models.Anuncio;
import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class mAnunciosActivity extends AppCompatActivity {

    ListView listView;
    dbHelper db = new dbHelper(this);
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_anuncios);

        listView = findViewById(R.id.listview);

        u  = (User) getIntent().getSerializableExtra("usuario");

        carregarListagem();

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Anuncio> anuncios = db.buscaAnunUsu(u);
                Anuncio anun = anuncios.get(position);
                Intent intent = new Intent(mAnunciosActivity.this, mAnunDetalhesActivity.class);
                intent.putExtra("anun", anun);
                intent.putExtra("usuario", u);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Context ctx = view.getContext();

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação").setMessage("Tem certeza que deseja excluir este anúncio?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        List<Anuncio> anuncios = db.buscaAnunUsu(u);
                        Anuncio anun = anuncios.get(position);
                        db.delAnun(anun);
                        carregarListagem();
                        db.closeDB();
                        Toast.makeText(ctx, "anúncio excluído com sucesso!", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("Cancelar", null).create().show();
                return false;
            }
        });

    }

    public void carregarListagem(){
        List<Anuncio> anuncios = db.buscaAnunUsu(u);
        if(anuncios.size() == 0){
            Toast.makeText(this, "Nenhum anúncio postado!", Toast.LENGTH_SHORT).show();
        }

        List<String> titulos = new ArrayList<>();
        for(int i = 0 ; i< anuncios.size(); i++){
            Anuncio w = anuncios.get(i);
            titulos.add(w.getTitulo());
        }

        ArrayAdapter<String> anunAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titulos);
        listView.setAdapter(anunAdapter);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarListagem();
    }
}
