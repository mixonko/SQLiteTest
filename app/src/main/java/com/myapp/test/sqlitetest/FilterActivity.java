package com.myapp.test.sqlitetest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class FilterActivity extends Activity {
    private CheckBox manufacturer;
    private CheckBox model;
    private CheckBox sortByPrice;
    private EditText manufacturerEt;
    private EditText modelEt;
    private Button ok;
    private Button cancel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        manufacturer = findViewById(R.id.manufacturer);
        model = findViewById(R.id.model);
        sortByPrice = findViewById(R.id.sortByPrice);
        manufacturerEt = findViewById(R.id.manufacturerEt);
        modelEt = findViewById(R.id.modelEt);
        ok = findViewById(R.id.ok);
        cancel = findViewById(R.id.cancel);

        manufacturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sortByPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
