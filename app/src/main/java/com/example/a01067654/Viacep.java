package com.example.a01067654;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Viacep {

    private String CEP;
    private String Logradouro;
    private String Complemento;
    private String Bairro;
    private String Localidade;
    private String Uf;
    private String Ibge;

    public Viacep() {
        this.CEP = null;
        this.Logradouro = null;
        this.Complemento = null;
        this.Bairro = null;
        this.Localidade = null;
        this.Uf = null;
        this.Ibge = null;
    }

    public Viacep(String CEP) throws ViaCEPException, JSONException {
        this.buscar(CEP);
    }

    public final void buscar(String cep) throws ViaCEPException, JSONException {
        this.CEP = CEP;

        String url = "http://viacep.com.br/ws/" + CEP + "/json/";

        try {
            JSONObject obj = new JSONObject(this.get(url));
            if (!obj.has("erro")) {
                this.CEP = obj.getString("cep");
                this.Logradouro = obj.getString("logradouro");
                this.Complemento = obj.getString("complemento");
                this.Bairro = obj.getString("bairro");
                this.Localidade = obj.getString("localidade");
                this.Uf = obj.getString("uf");
                this.Ibge = obj.getString("ibge");
            } else {
                throw new ViaCEPException("Não foi possível encontrar o CEP", CEP);
            }
        }catch (Exception e){}
    }

    public String getCEP() {
        return this.CEP;
    }

    public String getLogradouro() {
        return this.Logradouro;
    }

    public String getComplemento() {
        return this.Complemento;
    }

    public String getBairro() {
        return this.Bairro;
    }

    public String getLocalidade() {
        return this.Localidade;
    }

    public String getUf() {
        return this.Uf;
    }

    public String getIbge() {
        return this.Ibge;
    }


    public final String get(String urlToRead) throws ViaCEPException {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException ex) {
            throw new ViaCEPException(ex.getMessage());
        }

        return result.toString();
    }
}
