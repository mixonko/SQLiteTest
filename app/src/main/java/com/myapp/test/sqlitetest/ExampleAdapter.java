package com.myapp.test.sqlitetest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapp.test.sqlitetest.Entity.Car;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private List<Car> exampleItems;

    public ExampleAdapter(List<Car> exampleItems) {
        this.exampleItems = exampleItems;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);
            textView4 = itemView.findViewById(R.id.price);
        }
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(v);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        Car currentItem = exampleItems.get(i);

//        exampleViewHolder.imageView.setImageResource(currentItem.getImageResource());
        exampleViewHolder.textView1.setText(currentItem.getCarModel());
        exampleViewHolder.textView2.setText(currentItem.getCarName());
        exampleViewHolder.textView3.setText(currentItem.getManufacturer());
        exampleViewHolder.textView4.setText("Цена: " + currentItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }


}
