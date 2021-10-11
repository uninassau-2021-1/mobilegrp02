package com.example.a01067654;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import viacep.Viacep;

class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    private Button btnBuscar;
    private TextView txtCEP;
    private TextView txtLogradouro;
    private TextView txtComplemento;
    private TextView txtBairro;
    private EditText txtLocalidade;
    private TextView txtUf;
    private Viacep vCEP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.btnBuscar = (Button) findViewById(R.id.btn_Searchcep);
        this.txtCEP = (TextView) findViewById(R.id.tv_cep);
        this.txtLogradouro = (TextView) findViewById(R.id.tv_rua);
        this.txtComplemento = (TextView) findViewById(R.id.tv_comp);
        this.txtBairro = (TextView) findViewById(R.id.tv_Cidade);
        this.txtUf = (TextView) findViewById(R.id.tv_uf);

        // define o evento de clique
        this.btnBuscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == this.btnBuscar) {
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                this.txtBairro.setText("");
                this.txtComplemento.setText("");
                this.txtLocalidade.setText("");
                this.txtLogradouro.setText("");
                this.txtUf.setText("");

                String cep = this.txtCEP.getText().toString();

            }
        }
    }

}
