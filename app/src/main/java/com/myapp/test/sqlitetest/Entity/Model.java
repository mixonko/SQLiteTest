package com.myapp.test.sqlitetest.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "models")
public class Model {
    public Model(String name) {
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "model_name")
    private String name;

    @ColumnInfo(name = "id_manufacturer")
    @ForeignKey( entity = Manufacturer.class, parentColumns = "id", childColumns = "id_manufacturer" )
    private int idManufacturer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }
}
