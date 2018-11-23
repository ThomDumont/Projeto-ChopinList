package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.chopinslist.Models.Anuncio;

public class AnunDetalhesActivity extends AppCompatActivity {

    TextView tit,desc;
    Anuncio a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anun_detalhes);

        tit = findViewById(R.id.textTit);
        desc = findViewById(R.id.textDesc);
        a = (Anuncio) getIntent().getSerializableExtra("anun");

        tit.setText(a.getTitulo());
        desc.setText(a.getDesc());

    }
}
