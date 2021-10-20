package com.example.a01067654;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a01067654.domain.CepListener;

public class SgnActivity extends AppCompatActivity {

    private EditText ZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZipCode =(EditText) findViewById(R.id.ZipCode);
        ZipCode.addTextChangedListener(new CepListener());
    }
}
