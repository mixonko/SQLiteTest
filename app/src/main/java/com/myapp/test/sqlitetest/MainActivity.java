package com.myapp.test.sqlitetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.myapp.test.sqlitetest.Database.MyAppDatabase;
import com.myapp.test.sqlitetest.Entity.Car;
import com.myapp.test.sqlitetest.Entity.Manufacturer;
import com.myapp.test.sqlitetest.Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MyAppDatabase database;
    private Button addCar;
    public static List<Car> cars;
    public static final String CAR = "car";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = MyAppDatabase.getDatabase(getApplicationContext());

        fillManufacturer();
        fillModel();
        fillCar();

        cars = database.carDao().getAllCar();

        addCar = findViewById(R.id.addCar);

        recyclerView = findViewById(R.id.recyclerView);
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
            public void onItemLongClick(int position) {
                 removeItem(position);
            }
        });

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();
            }
        });
    }

    private void fillManufacturer() {
        database.manufacturerDao().addManufacturer(new Manufacturer("Япония"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Китай"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Германия"));
    }

    private void fillModel() {
        database.modelDao().addModel(new Model("Toyota"));
        database.modelDao().addModel(new Model("Nissan"));
        database.modelDao().addModel(new Model("Mazda"));
        database.modelDao().addModel(new Model("Geely"));
        database.modelDao().addModel(new Model("Chery"));
        database.modelDao().addModel(new Model("Lifan"));
        database.modelDao().addModel(new Model("Audi"));
        database.modelDao().addModel(new Model("Volkswagen"));
        database.modelDao().addModel(new Model("Opel"));
    }

    private void fillCar() {
        database.carDao().addCar(new Car("Nissan","Almera 1.4", "Япония", R.drawable.nissan_almera ,"январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Toyota","Allion 1.5", "Япония", R.drawable.toyota_allion,"январь 2005 г.", "седан 4 дв.", "1496 cм3", "109 л.с.", "430 000 Р"));
        database.carDao().addCar(new Car("Mazda", "2 1.3","Япония", R.drawable.mazda_2,"ноябрь 2008 г.", " хэтчбек 5 дв.", "1349 cм3", "75 л.с.", "354 707 Р"));
        database.carDao().addCar(new Car("Geely", "Emgrand EC7 1.5","Китай", R.drawable.geely_emgrand,"2014 г.", "седан 4 дв.", "1498 cм3", " 98 л.с", "365 000 Р"));
        database.carDao().addCar(new Car("Chery", "A1/Kimo 1.3","Китай", R.drawable.chery_a1," 2009 г.", "хэтчбек 5 дв.", "1297 cм3", "83 л.с.", "155 000 Р"));
        database.carDao().addCar(new Car("Lifan", "320 1.3","Китай", R.drawable.lifan_320,"июль 2013 г.", "хэтчбек 5 дв.", "1342 cм3", "89 л.с.", "220 000 Р"));
        database.carDao().addCar(new Car("Audi", "A3 1.2 TFSI", "Германия", R.drawable.audi_a3,"январь 2009 г.", "кабриолет 2 дв.", "1197 cм3", "105 л.с.", "595 000 Р"));
        database.carDao().addCar(new Car("Volkswagen", "Golf","Германия", R.drawable.volkswagen_golf,"январь 2014 г.", "купе 3 дв.", "2000 cм3", "301 л.с.", "2 000 000 Р"));
        database.carDao().addCar(new Car("Opel", "Antara 2.0","Германия", R.drawable.opel_antara,"январь 2008 г.", "внедорожник 5 дв.", "1991 cм3", "127 л.с.", ""));
        database.carDao().addCar(new Car("Opel","Calibra 2.0","Германия", R.drawable.opel_calibra,"1991 г.", "купе 2 дв.", "1998 cм3", "115 л.с.", "90 000 Р"));
        database.carDao().addCar(new Car("Opel", "Omega B 2.0","Германия", R.drawable.opel_omega,"сентябрь 1995 г.", "седан 4 дв.", "1998 cм3", "136 л.с.", "75 000 Р"));
        database.carDao().addCar(new Car("Opel", "Zafira 1.6","Германия", R.drawable.opel_zafira,"ноябрь 2000 г.", "минивэн 5 дв.", "1598 cм3", "101 л.с.", "296 280 Р"));

    }



    private void carInfo(int position) {
        Intent intent = new Intent(MainActivity.this, CarInfoActivity.class);
        intent.putExtra(CAR, String.valueOf(position));
        startActivity(intent);
    }

    public void insertItem(){

    }

    public void removeItem(int position){

        Car car = cars.get(position);
        cars.remove(position);
        database.carDao().removeCar(car);
        adapter.notifyItemRemoved(position);


    }
}
