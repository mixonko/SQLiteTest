package com.myapp.test.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.myapp.test.sqlitetest.Database.MyAppDatabase;
import com.myapp.test.sqlitetest.Entity.Car;
import com.myapp.test.sqlitetest.Entity.Manufacturer;
import com.myapp.test.sqlitetest.Entity.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MyAppDatabase database;
    private ArrayList<ExampleItem> exampleItems;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = MyAppDatabase.getDatabase(getApplicationContext());

         fillDataBase();

        b = findViewById(R.id.button);

        exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee", "123"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd", "1213"));


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Model> l = database.modelDao().getAllModel();
                Model m = l.get(3);

                b.setText(String.valueOf(m.getName()));
            }
        });
    }




    private void fillDataBase() {
        database.manufacturerDao().addManufacturer(new Manufacturer("Япония"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Китай"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Германия"));

        database.modelDao().addModel(new Model("Toyota"));
        database.modelDao().addModel(new Model("Nissan"));
        database.modelDao().addModel(new Model("Mazda"));
        database.modelDao().addModel(new Model("Geely"));
        database.modelDao().addModel(new Model("Chery"));
        database.modelDao().addModel(new Model("Lifan"));
        database.modelDao().addModel(new Model("Audi"));
        database.modelDao().addModel(new Model("Volkswagen"));
        database.modelDao().addModel(new Model("Opel"));


        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Toyota Allion 1.5", "январь 2005 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "430 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));
        database.carDao().addCar(new Car("Nissan Almera 1.4", "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", "135 000 Р"));

    }
}
