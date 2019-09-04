package com.myapp.test.sqlitetest.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.myapp.test.sqlitetest.R;

@Entity(tableName = "cars")
public class Car {
    public Car(String carModel, String carName, String manufacturer, int photo, String year, String bodyType, String engineCapacity, String enginePower, int price) {
        this.carModel = carModel;
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.photo = photo;
        this.year = year;
        this.bodyType = bodyType;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.price = price;
    }

    @Ignore
    public Car(String carModel, String carName, String manufacturer, String year, String bodyType, String engineCapacity, String enginePower, int price) {
        this.carModel = carModel;
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.year = year;
        this.bodyType = bodyType;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.price = price;
        this.photo = R.drawable.car;
    }

    @PrimaryKey( autoGenerate = true )
    private int id;

    @ColumnInfo( name = "car_model" )
    private String carModel;

    @ColumnInfo( name = "car_name" )
    private String carName;

    @ColumnInfo( name = "manufacturer" )
    private String manufacturer;

    @ColumnInfo( name = "photo" )
    private int photo;

    @ColumnInfo( name = "year" )
    private String year;

    @ColumnInfo( name = "body_type" )
    private String bodyType;

    @ColumnInfo( name = "engine_capacity" )
    private String engineCapacity;

    @ColumnInfo( name = "engine_power" )
    private String enginePower;

    @ColumnInfo( name = "price" )
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
