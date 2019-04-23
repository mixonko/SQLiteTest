package com.myapp.test.sqlitetest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.myapp.test.sqlitetest.Database.MyAppDatabase;
import com.myapp.test.sqlitetest.Entity.Car;
import com.myapp.test.sqlitetest.adapter.ExampleAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static MyAppDatabase database;
    private Button addCar;
    private RadioGroup radioGroup;
    public static List<Car> cars;
    public static final String CAR = "car";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = MyAppDatabase.getDatabase(getApplicationContext());
        new FillDataBase();

        cars = database.carDao().getAllCar();

        recyclerView = findViewById(R.id.recyclerView);
        addCar = findViewById(R.id.addCar);

        createRecyclerVeiew(cars);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId() == R.id.none) {
                    cars = database.carDao().getAllCar();
                    createRecyclerVeiew(cars);
                }

                if(radioGroup.getCheckedRadioButtonId() == R.id.sortB) {
                    cars = database.carDao().getAllCarPriceSortedDESC();
                    createRecyclerVeiew(cars);
                }


                if(radioGroup.getCheckedRadioButtonId() == R.id.sortA) {
                    cars = database.carDao().getAllCarPriceSorted();
                    createRecyclerVeiew(cars);
                }

            }
        });

    }

    private void createRecyclerVeiew(final List<Car> cars) {
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(cars);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                carInfo(position);
            }
        });
        adapter.setOnItemLongClickListener(new ExampleAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(final int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Удалить " + cars.get(position).getCarModel() + cars.get(position).getCarName() + "?")
                        .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                removeItem(position);
                            }
                        })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();

            }
        });
    }


    private void carInfo(int position) {
        Intent intent = new Intent(MainActivity.this, CarInfoActivity.class);
        intent.putExtra(CAR, String.valueOf(position));
        startActivity(intent);
    }

    public void insertItem() {
        Intent intent = new Intent(MainActivity.this, InsertCarActyvity.class);
        startActivity(intent);
    }

    public void removeItem(int position) {
        Car car = cars.get(position);
        cars.remove(position);
        database.carDao().removeCar(car);
        adapter.notifyItemRemoved(position);
        Toast.makeText(MainActivity.this,  car.getCarModel() + car.getCarName() + " удален", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


}


