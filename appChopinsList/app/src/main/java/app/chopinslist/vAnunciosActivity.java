package app.chopinslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.chopinslist.Models.Anuncio;
import app.chopinslist.helper.dbHelper;

public class vAnunciosActivity extends AppCompatActivity {

    ListView listView;
    dbHelper db = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_anuncios);

        listView =  findViewById(R.id.lista);
        carregarListagem();

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anuncio anun = (Anuncio) listView.getItemAtPosition(position);
                Intent intent = new Intent(vAnunciosActivity.this, AnunDetalhesActivity.class);
                intent.putExtra("anun", anun);
                startActivity(intent);
            }
        });
    }



    public void carregarListagem(){
        List<Anuncio> anuncios = db.getallAnuncios();
        if(anuncios.size() == 0){
            Toast.makeText(this, "Nenhum cliente cadastrado!", Toast.LENGTH_SHORT).show();
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





