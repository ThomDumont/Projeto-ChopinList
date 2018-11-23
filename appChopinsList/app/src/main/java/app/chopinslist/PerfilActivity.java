package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class PerfilActivity extends AppCompatActivity {

    TextView login, senha, nome, tele, email;
    User u;

    dbHelper db = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        login = findViewById(R.id.pLogin);
        senha = findViewById(R.id.pSenha);
        nome = findViewById(R.id.pNome);
        tele = findViewById(R.id.pTelefone);
        email = findViewById(R.id.pEmail);
        u = (User) getIntent().getSerializableExtra("usuario");

        User w = db.buscaUsuario(u);

        login.setText(w.getLogin());
        senha.setText(w.getSenha());
        nome.setText(w.getNome());
        tele.setText(w.getTelefone());
        email.setText(w.getEmail());


    }
}
