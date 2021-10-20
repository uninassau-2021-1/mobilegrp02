package com.example.a01067654.domain;

import android.text.Editable;
import android.text.TextWatcher;

public class CepListener implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String ZipCode = editable.toString();

        if(editable.length()== 8){}

    }
}
