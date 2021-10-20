package com.example.a01067654;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a01067654.domain.CepListener;
import com.example.a01067654.domain.Endereco;

public class SgnActivity extends AppCompatActivity {

    private EditText ZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZipCode = (EditText) findViewById(R.id.ZipCode);
        ZipCode.addTextChangedListener(new CepListener(this));

    }

    public String getUriZipCode(){

        return "https://viacep.com.br/ws/" + ZipCode.getText() + "/json/";
    }

    public void setDataViews(Endereco endereco){
        setField(R.id.tv_logra, endereco.getLogradouro());
        setField(R.id.tv_comp,endereco.getComplemento());
        setField(R.id.tv_Cidade,endereco.getLocalidade());
        setField(R.id.tv_bairro,endereco.getBairro());
        setField(R.id.tv_uf,endereco.getUf());

    }

    public void setField(int id,String data){
        ((TextView) findViewById(id)).setText( data );
    }
}
