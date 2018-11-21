package app.chopinslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarActivity extends AppCompatActivity {

    EditText camp_addlogin, camp_addsenha;
    Button btn_adduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        camp_addlogin = (EditText) findViewById(R.id.camp_addlogin);
        camp_addsenha = (EditText) findViewById(R.id.camp_addsenha);

        btn_adduser = (Button) findViewById(R.id.btn_adduser);

        btn_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
