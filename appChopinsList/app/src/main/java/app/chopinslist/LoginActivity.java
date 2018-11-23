package app.chopinslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class LoginActivity extends AppCompatActivity {
    Button btn_logar, btn_cadastrar;
    EditText camp_login, camp_senha;
    dbHelper db = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        camp_login = findViewById(R.id.camp_login);
        camp_senha = findViewById(R.id.camp_senha);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        btn_logar = findViewById(R.id.btn_logar);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String login = camp_login.getText().toString();
                String senha = camp_senha.getText().toString();
                User w = new User(login,senha);
                if(db.verificaUsuario(w)){
                    Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                    it.putExtra("usu", (Serializable) w);
                    startActivity(it);
                }else{
                    alert("Login e/ou senha incorretos");
                }
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