package com.myapp.test.sqlitetest.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.myapp.test.sqlitetest.Entity.Manufacturer;

import java.util.List;

@Dao
public interface ManufacturerDao {

    @Insert
    public void addManufacturer(Manufacturer manufacturer);

    @Query("select * from manufacturers where manufacturer_name = :name")
    public Manufacturer getManufacturer(String name);

    @Query("select * from manufacturers where manufacturer_name")
    public List<Manufacturer> getAllManufacturer();
}
