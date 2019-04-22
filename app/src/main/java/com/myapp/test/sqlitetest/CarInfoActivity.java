package com.myapp.test.sqlitetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.test.sqlitetest.Entity.Car;

public class CarInfoActivity extends Activity {
    private ImageView image;
    private TextView carModel;
    private TextView carName;
    private TextView manufacturer;
    private TextView year;
    private TextView bodyType;
    private TextView engineCapacity;
    private TextView enginePower;
    private TextView price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_info);

        image = findViewById(R.id.image);
        carModel= findViewById(R.id.carModel);
        carName= findViewById(R.id.carName);
        manufacturer= findViewById(R.id.manufacturer);
        year= findViewById(R.id.year);
        bodyType= findViewById(R.id.bodyType);
        engineCapacity= findViewById(R.id.engineCapacity);
        enginePower= findViewById(R.id.enginePower);
        price= findViewById(R.id.price);

        Car car = MainActivity.cars.get(Integer.parseInt(getIntent().getStringExtra(MainActivity.CAR)));
    }
}
