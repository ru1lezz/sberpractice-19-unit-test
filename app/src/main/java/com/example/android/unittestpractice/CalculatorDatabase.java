package com.example.android.unittestpractice;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = ResultEntity.class, version = 1)
public abstract class CalculatorDatabase extends RoomDatabase {

    public abstract CalculatorDAO getCalculatorDao();
}
