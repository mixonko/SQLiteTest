package com.myapp.test.sqlitetest.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cars")
public class Car {
    public Car(String carName, String manufacturer, String year, String bodyType, String engineCapacity, String enginePower, String price) {
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.year = year;
        this.bodyType = bodyType;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.price = price;
    }

    @PrimaryKey( autoGenerate = true )
    private int id;

    @ColumnInfo( name = "id_manufacturer" )
    @ForeignKey( entity = Manufacturer.class, parentColumns = "id", childColumns = "id_manufacturer" )
    private int idManufacturer;

    @ColumnInfo( name = "id_model" )
    @ForeignKey( entity = Model.class, parentColumns = "id", childColumns = "id_model" )
    private int idModel;

    @ColumnInfo( name = "car_name" )
    private String carName;

    @ColumnInfo( name = "manufacturer" )
    private String manufacturer;

//    @ColumnInfo( name = "photo" )
//    private Bitmap photo;

    @ColumnInfo( name = "year" )
    private String year;

    @ColumnInfo( name = "body_type" )
    private String bodyType;

    @ColumnInfo( name = "engine_capacity" )
    private String engineCapacity;

    @ColumnInfo( name = "engine_power" )
    private String enginePower;

    @ColumnInfo( name = "price" )
    private String price;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

//    public Bitmap getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(Bitmap photo) {
//        this.photo = photo;
//    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}