package app.chopinslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btn_logar, btn_cadastrar;
    EditText camp_login, camp_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        camp_login = (EditText) findViewById(R.id.camp_login);
        camp_senha = (EditText) findViewById(R.id.camp_senha);
        btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btn_logar = (Button) findViewById(R.id.btn_logar);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String login = camp_login.getText().toString();
                String senha = camp_senha.getText().toString();
               // if (login.equals("thomas")||login.equals("marcio") && senha.equals("123")) {
                    Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(it);
              //  } else {
                  //  alert("Login e/ou senha incorretos");
                //}
            }
        });
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, CadastrarActivity.class);
                startActivity(it);
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}

