package com.example.a01067654;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {

    TextView et_username, et_pass1, et_pass2;
    Button bt_registrar;

    DBHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);

        et_username = findViewById(R.id.et_reg_username);
        et_pass1 = findViewById(R.id.et_reg_password1);
        et_pass2 = findViewById(R.id.et_reg_password2);

        bt_registrar = findViewById(R.id.bt_registrarnovo);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = et_username.getText().toString();
                String p1 = et_pass1.getText().toString();
                String p2 = et_pass2.getText().toString();

                if (usuario.equals("")){
                    Toast.makeText(getApplicationContext(),"Usuario nao inserido",Toast.LENGTH_SHORT).show();
                } else if (p1.equals("") || p2.equals("")){
                    Toast.makeText(getApplicationContext(),"Preencher o password",Toast.LENGTH_SHORT).show();
                } else if (!p1.equals(p2)){
                    Toast.makeText(getApplicationContext(),"Senhas não coincidem!",Toast.LENGTH_SHORT).show();
                } else {
                    long res = db.CriarUtilizador(usuario,p1);
                    if (res>0){
                        Toast.makeText(getApplicationContext(),"Registro OK",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
