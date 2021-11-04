package com.example.a01067654;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btnEntrar;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this);


        et_username = findViewById(R.id.editLogin);
        et_password = findViewById(R.id.editSenha);

        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (usuario.equals("")){
                    Toast.makeText(getApplicationContext(),"Usuario não inserido, tente novamente",Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(getApplicationContext(),"Senha não inserida, tente novamente",Toast.LENGTH_SHORT).show();
                }else{
                    //Deu ok
                    String res = db.ValidarLogin(usuario,password);

                    if (res.equals("Ok")){
                        Toast.makeText(getApplicationContext(),"Validando seus dados... aguarde",Toast.LENGTH_SHORT).show();
                        Intent main1 = new Intent(LoginActivity.this,SgnActivity.class);
                        startActivity(main1);
                    } else {
                        Toast.makeText(getApplicationContext(),"Login errado, tente novamente",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
