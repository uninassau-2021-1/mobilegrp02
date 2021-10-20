package com.example.a01067654.domain;

import android.os.AsyncTask;

import com.example.a01067654.SgnActivity;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

public class EnderecoRequest extends AsyncTask<Void, Void, Endereco> {
    private WeakReference<SgnActivity> activity;

    public EnderecoRequest(SgnActivity activity) {
        this.activity = new WeakReference<>(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Endereco doInBackground(Void... voids) {
        try {
            String jsonString = Jsonrequest.request(activity.get().getUriZipCode());

            Gson gson = new Gson();
            return gson.fromJson(jsonString,Endereco.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Endereco endereco) {
        super.onPostExecute(endereco);

        if (endereco != null){
            activity.get().setDataViews(endereco);
        }

    }
}
