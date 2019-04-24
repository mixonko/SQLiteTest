package com.myapp.test.sqlitetest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.myapp.test.sqlitetest.Database.MyAppDatabase;
import com.myapp.test.sqlitetest.Entity.Car;
import com.myapp.test.sqlitetest.adapter.ExampleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static MyAppDatabase database;
    private Button addCar;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText search;
    private ArrayList<Car> filteList;
    public static List<Car> cars;
    public static final String CAR = "car";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = MyAppDatabase.getDatabase(getApplicationContext());
        cars = database.carDao().getAllCar();
        if (cars.size() == 0) {
            new FillDataBase();
        }

        recyclerView = findViewById(R.id.recyclerView);
        addCar = findViewById(R.id.addCar);
        search = findViewById(R.id.search);

        createRecyclerVeiew(cars);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.none);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() == R.id.none) {
                    cars = database.carDao().getAllCar();
                    createRecyclerVeiew(cars);
                    filter(search.getText().toString());
                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.sortB) {
                    cars = database.carDao().getAllCarPriceSortedDESC();
                    createRecyclerVeiew(cars);
                    filter(search.getText().toString());
                }


                if (radioGroup.getCheckedRadioButtonId() == R.id.sortA) {
                    cars = database.carDao().getAllCarPriceSorted();
                    createRecyclerVeiew(cars);
                    filter(search.getText().toString());
                }

            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cars = database.carDao().getAllCar();
                createRecyclerVeiew(cars);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(search.getText().toString());
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

                if (search.getText().toString().isEmpty()) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Удалить " + cars.get(position).getCarModel() + " " + cars.get(position).getCarName() + "?")
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
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Удалить " + filteList.get(position).getCarModel() + " " + filteList.get(position).getCarName() + "?")
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

            }
        });
    }

    private void carInfo(int position) {
        Intent intent = new Intent(MainActivity.this, CarInfoActivity.class);

        if (search.getText().toString().isEmpty()) {
            intent.putExtra(CAR, String.valueOf(position));
            startActivity(intent);
        } else {
            Car car = filteList.get(position);
            int p = cars.indexOf(car);

            intent.putExtra(CAR, String.valueOf(p));
            startActivity(intent);
        }

    }

    public void insertItem() {
        Intent intent = new Intent(MainActivity.this, InsertCarActyvity.class);
        startActivity(intent);
    }

    public void removeItem(int position) {
        if (search.getText().toString().isEmpty()) {
            Car car = cars.get(position);
            database.carDao().removeCar(car);
            cars = database.carDao().getAllCar();
            createRecyclerVeiew(cars);
            Toast.makeText(MainActivity.this, car.getCarModel() + " " + car.getCarName() + " удален", Toast.LENGTH_SHORT).show();
        } else {
            Car car = filteList.get(position);
            filteList.remove(position);
            database.carDao().removeCar(car);
            adapter.notifyItemRemoved(position);
            Toast.makeText(MainActivity.this, car.getCarModel() + " " + car.getCarName() + " удален", Toast.LENGTH_SHORT).show();
        }

    }

    private void filter(String text) {

        filteList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarName().toLowerCase().contains(text.toLowerCase())
                    || car.getCarModel().toLowerCase().contains(text.toLowerCase())
                    || car.getManufacturer().toLowerCase().contains(text.toLowerCase())) {
                filteList.add(car);

            }
        }
        adapter.filterList(filteList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyItemInserted(cars.size());
        search.setText("");
        radioButton.setChecked(true);

    }

}


