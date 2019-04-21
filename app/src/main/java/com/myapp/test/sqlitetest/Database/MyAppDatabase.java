package com.myapp.test.sqlitetest.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.myapp.test.sqlitetest.Dao.ManufacturerDao;
import com.myapp.test.sqlitetest.Dao.ModelDao;
import com.myapp.test.sqlitetest.Entity.Manufacturer;
import com.myapp.test.sqlitetest.Entity.Model;

@Database( entities = {Manufacturer.class, Model.class}, version = 1 )
public abstract class MyAppDatabase extends RoomDatabase {

    private static MyAppDatabase INSTANCE;

    public abstract ManufacturerDao manufacturerDao();

    public abstract ModelDao modelDao();


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
