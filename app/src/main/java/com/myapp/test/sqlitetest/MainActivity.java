package com.myapp.test.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.myapp.test.sqlitetest.Database.MyAppDatabase;
import com.myapp.test.sqlitetest.Entity.Manufacturer;

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
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));




        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    private void fillDataBase(){
        database.manufacturerDao().addManufacturer(new Manufacturer("Япония"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Китай"));
        database.manufacturerDao().addManufacturer(new Manufacturer("Германия"));
    }
}
