package app.chopinslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.chopinslist.Models.User;
import app.chopinslist.helper.dbHelper;

public class CadastrarActivity extends AppCompatActivity {

    EditText camp_addlogin, camp_addsenha, editEmail, editNome, editTelefone;
    Button btn_adduser;
    User usuario = new User();
    dbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        db = new dbHelper(getApplicationContext());

        camp_addlogin = findViewById(R.id.camp_addlogin);
        camp_addsenha = findViewById(R.id.camp_addsenha);
        editEmail = findViewById(R.id.editEmail);
        editNome = findViewById(R.id.editNome);
        editTelefone = findViewById(R.id.editTelefone);
        btn_adduser = findViewById(R.id.btn_adduser);

        btn_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setLogin(camp_addlogin.getText().toString());
                usuario.setSenha(camp_addsenha.getText().toString());
                usuario.setEmail(editEmail.getText().toString());
                usuario.setNome(editNome.getText().toString());
                usuario.setTelefone(editTelefone.getText().toString());
                db.createUsuarios(usuario);
                db.closeDB();
                alert("Criado com sucesso!");
                finish();

            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}
