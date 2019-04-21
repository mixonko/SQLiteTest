package com.myapp.test.sqlitetest.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity( tableName = "manufacturers" )
public class Manufacturer {
    public Manufacturer(String name) {
        this.name = name;
    }

    @PrimaryKey( autoGenerate = true )
    private int id;

    @ColumnInfo( name = "manufacturer_name" )
    private String name;

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
}
