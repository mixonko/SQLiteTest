package com.myapp.test.sqlitetest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.test.sqlitetest.Entity.Car;

import static com.myapp.test.sqlitetest.MainActivity.cars;

public class InsertCarActyvity extends Activity {
    private TextView carModel;
    private TextView carName;
    private TextView manufacturer;
    private TextView year;
    private TextView bodyType;
    private TextView engineCapacity;
    private TextView enginePower;
    private TextView price;
    private Button save;
    private Button cancel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_car);

        carModel= findViewById(R.id.carModel);
        carName= findViewById(R.id.carName);
        manufacturer= findViewById(R.id.manufacturer);
        year= findViewById(R.id.year);
        bodyType= findViewById(R.id.bodyType);
        engineCapacity= findViewById(R.id.engineCapacity);
        enginePower= findViewById(R.id.enginePower);
        price= findViewById(R.id.price);
        save= findViewById(R.id.save);
        cancel= findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCar();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void saveCar(){

        if (carModel.getText().toString().isEmpty()||carName.getText().toString().isEmpty()
                ||manufacturer.getText().toString().isEmpty()||year.getText().toString().isEmpty()
                ||bodyType.getText().toString().isEmpty()||engineCapacity.getText().toString().isEmpty()
                ||enginePower.getText().toString().isEmpty()||price.getText().toString().isEmpty()){
            Toast.makeText(InsertCarActyvity.this, "Введите данные", Toast.LENGTH_SHORT).show();
        }else{
            Car car = new Car(carModel.getText().toString(),
                    carName.getText().toString(),
                    manufacturer.getText().toString(),
                    year.getText().toString(),
                    bodyType.getText().toString(),
                    engineCapacity.getText().toString(),
                    enginePower.getText().toString(),
                    price.getText().toString());
            MainActivity.database.carDao().addCar(car);
            cars.add(car);
            finish();
        }

    }

}
