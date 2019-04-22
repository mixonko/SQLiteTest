package com.myapp.test.sqlitetest.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myapp.test.sqlitetest.Entity.Car;

import java.util.List;

@Dao
public interface CarDao {

    @Insert
    public void addCar(Car car);

    @Query("select * from cars where car_name = :name")
    public Car getCar(String name);

    @Query("select * from cars")
    public List<Car> getAllCar();

    @Delete
    public void removeCar(Car car);

    @Update
    public void update(Car car);

}
