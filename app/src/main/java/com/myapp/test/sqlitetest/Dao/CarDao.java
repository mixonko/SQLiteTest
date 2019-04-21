package com.myapp.test.sqlitetest.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.myapp.test.sqlitetest.Entity.Car;

import java.util.List;

@Dao
public interface CarDao {

    @Insert
    public void addCar(Car car);

    @Query("select * from cars where car_name = :name")
    public Car getCar(String name);

    @Query("select * from cars where car_name")
    public List<Car> getAllCar();

}
