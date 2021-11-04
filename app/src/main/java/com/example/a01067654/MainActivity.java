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

    Button bt_entrar, bt_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_login);

        bt_entrar = findViewById(R.id.bt_entrar);
        bt_registrar = findViewById(R.id.bt_registrar);

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }

        });

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(i);
            }

        });
    }
}
