package com.myapp.test.sqlitetest.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.myapp.test.sqlitetest.Entity.Model;

import java.util.List;

@Dao
public interface ModelDao {

    @Insert
    public void addModel(Model model);

    @Query("select * from models where model_name = :name")
    public Model getModel(String name);

    @Query("select * from models")
    public List<Model> getAllModel();


}
