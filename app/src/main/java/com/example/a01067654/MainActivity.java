package com.example.a01067654;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a01067654.domain.CepListener;

public class MainActivity extends AppCompatActivity {

    String urlWebServices = "http://127.0.0.2/phpmyadmin/";

    Button btnLogin;
    EditText editLogin;
    EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnEntrar);
        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validacampo = true;

                if (editLogin.getText().equals("")){
                    editLogin.setError("Campo Obrigatório");
                    editLogin.requestFocus();
                    validacampo = false;
                }
                if (editSenha.getText().equals("")){
                    editSenha.setError("Campo Obrigatório");
                    editSenha.requestFocus();
                    validacampo = false;
                }
                if (validacampo){
                    Toast.makeText(getApplicationContext(),"Validando seus dados... aguarde",Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }

        });
    }
}
