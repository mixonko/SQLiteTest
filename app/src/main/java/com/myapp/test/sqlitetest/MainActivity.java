package com.myapp.test.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "qqqqq", "wwwww", "eeeeee"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "aaaaa", "sssss", "ddddd"));
        exampleItems.add(new ExampleItem(R.drawable.vkapp, "zzzzz", "xxxxx", "cccccc"));

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
