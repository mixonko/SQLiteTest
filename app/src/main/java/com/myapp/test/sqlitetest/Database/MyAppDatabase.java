package com.myapp.test.sqlitetest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.myapp.test.sqlitetest.dao.CarDao;
import com.myapp.test.sqlitetest.entity.Car;

@Database( entities = {Car.class}, version = 1 )
public abstract class MyAppDatabase extends RoomDatabase {

    public static MyAppDatabase INSTANCE;

    public abstract CarDao carDao();


    public static MyAppDatabase getDatabase(Context context) {

        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, MyAppDatabase.class, "car_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();

        }
        return INSTANCE;
    }



}
