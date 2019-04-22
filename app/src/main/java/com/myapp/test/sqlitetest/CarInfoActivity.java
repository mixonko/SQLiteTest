package com.myapp.test.sqlitetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.myapp.test.sqlitetest.Entity.Car;

import static com.myapp.test.sqlitetest.MainActivity.cars;

public class CarInfoActivity extends Activity implements View.OnClickListener {
    private ImageView image;
    private TextView carModel;
    private TextView carName;
    private TextView manufacturer;
    private TextView year;
    private TextView bodyType;
    private TextView engineCapacity;
    private TextView enginePower;
    private TextView price;

    private Button change;
    private Button save;


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

        change= findViewById(R.id.change);
        save= findViewById(R.id.save);

        final Car car = MainActivity.cars.get(Integer.parseInt(getIntent().getStringExtra(MainActivity.CAR)));

        image.setImageResource(car.getPhoto());
        carModel.setText(car.getCarModel());
        carName.setText(car.getCarName());
        manufacturer.setText(car.getManufacturer());
        year.setText(car.getYear());
        bodyType.setText(car.getBodyType());
        engineCapacity .setText(car.getEngineCapacity());
        enginePower.setText(car.getEnginePower());
        price.setText(String.valueOf(car.getPrice()));

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carModel.setOnClickListener(CarInfoActivity.this);
                carName.setOnClickListener(CarInfoActivity.this);
                manufacturer.setOnClickListener(CarInfoActivity.this);
                year.setOnClickListener(CarInfoActivity.this);
                bodyType.setOnClickListener(CarInfoActivity.this);
                engineCapacity.setOnClickListener(CarInfoActivity.this);
                enginePower.setOnClickListener(CarInfoActivity.this);
                price.setOnClickListener(CarInfoActivity.this);
                save.setVisibility(View.VISIBLE);
                change.setVisibility(View.INVISIBLE);

                carModel.setTextColor(Color.RED);
                carName.setTextColor(Color.RED);
                manufacturer.setTextColor(Color.RED);
                year.setTextColor(Color.RED);
                bodyType.setTextColor(Color.RED);
                engineCapacity.setTextColor(Color.RED);
                enginePower.setTextColor(Color.RED);
                price.setTextColor(Color.RED);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car.setCarModel(carModel.getText().toString());
                car.setCarName(carName.getText().toString());
                car.setManufacturer(manufacturer.getText().toString());
                car.setYear(year.getText().toString());
                car.setBodyType(bodyType.getText().toString());
                car.setEngineCapacity(engineCapacity.getText().toString());
                car.setEnginePower(enginePower.getText().toString());
                car.setPrice(Integer.parseInt(price.getText().toString()));

                carModel.setClickable(false);
                carName.setClickable(false);
                manufacturer.setClickable(false);
                year.setClickable(false);
                bodyType.setClickable(false);
                engineCapacity.setClickable(false);
                enginePower.setClickable(false);
                price.setClickable(false);

                carModel.setTextColor(Color.BLACK);
                carName.setTextColor(Color.BLACK);
                manufacturer.setTextColor(Color.BLACK);
                year.setTextColor(Color.BLACK);
                bodyType.setTextColor(Color.BLACK);
                engineCapacity.setTextColor(Color.BLACK);
                enginePower.setTextColor(Color.BLACK);
                price.setTextColor(Color.BLACK);

                save.setVisibility(View.INVISIBLE);
                change.setVisibility(View.VISIBLE);

                MainActivity.database.carDao().update(car);
                Toast.makeText(CarInfoActivity.this, "Изменения сохранены", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.carModel:
                changeInfo(carModel.getText().toString(), carModel);
                break;

            case R.id.carName:
                changeInfo(carName.getText().toString(), carName);
                break;

            case R.id.manufacturer:
                changeInfo(manufacturer.getText().toString(), manufacturer);
                break;

            case R.id.year:
                changeInfo(year.getText().toString(), year);
                break;

            case R.id.bodyType:
                changeInfo(bodyType.getText().toString(), bodyType);
                break;

            case R.id.engineCapacity:
                changeInfo(engineCapacity.getText().toString(), engineCapacity);
                break;

            case R.id.enginePower:
                changeInfo(enginePower.getText().toString(), enginePower);
                break;

            case R.id.price:
                changeInfo(price.getText().toString(), price);
                break;
        }

    }
    private void changeInfo(String s, final TextView tv){
        final AlertDialog.Builder builder = new AlertDialog.Builder(CarInfoActivity.this);
        final EditText et = new EditText(CarInfoActivity.this);
        et.setText(s);
        builder.setView( et);
        builder.setTitle("Изменение")
                .setMessage("asd")
                .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText(et.getText().toString());
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setCancelable(false)
                .show();

    }


}
