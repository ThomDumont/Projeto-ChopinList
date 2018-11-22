package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AnunciarActivity extends AppCompatActivity {

    EditText txt_titulo, txt_descricao;
    Button btnAnunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar);

        txt_titulo = (EditText) findViewById(R.id.txt_titulo);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        btnAnunc = (Button) findViewById(R.id.btnAnunc);
        
    }


}
