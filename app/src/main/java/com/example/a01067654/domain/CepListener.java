package com.example.a01067654.domain;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.a01067654.SgnActivity;

public class CepListener implements TextWatcher {
    private Context context;

    public CepListener(Context context){
        this.context = context;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void afterTextChanged(Editable editable) {
        String ZipCode = editable.toString();

        if(editable.length()== 8){
            new EnderecoRequest((SgnActivity) context).execute();
        }

    }
}
