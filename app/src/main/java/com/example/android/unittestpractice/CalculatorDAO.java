package com.example.android.unittestpractice;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public abstract class CalculatorDAO {

    @Query("select * from ResultEntity")
    public abstract List<ResultEntity> getAll();

    @Query("select * from ResultEntity where id = :id")
    public abstract ResultEntity findById(double id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(ResultEntity calculatorEntity);

    @Query("delete from resultentity")
    public abstract void deleteAll();
}
