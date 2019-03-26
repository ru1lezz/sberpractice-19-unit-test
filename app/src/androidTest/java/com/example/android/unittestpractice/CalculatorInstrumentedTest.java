package com.example.android.unittestpractice;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentedTest {

    private CalculatorDatabase database;
    private Calculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getContext();
        calculator = new Calculator();
        database = Room.inMemoryDatabaseBuilder(context, CalculatorDatabase.class).build();
    }

    @After
    public void closeDb() {
        database.close();
    }

    @Test
    public void testAdd() {
        double result = calculator.add(3,5);
        ResultEntity temp = new ResultEntity(result);
        temp.setId(1);
        database.getCalculatorDao().insert(temp);
        ResultEntity resultEntity = database.getCalculatorDao().findById(1);
        assertEquals(temp, resultEntity);
    }

    @Test
    public void testGetAll() {
        double result = calculator.multiply(3,5);
        ResultEntity entity1 = new ResultEntity(result);
        entity1.setId(2);
        double result2 = calculator.divide(20,5);
        ResultEntity entity2 = new ResultEntity(result2);
        entity2.setId(3);
        database.getCalculatorDao().insert(entity1);
        database.getCalculatorDao().insert(entity2);
        List<ResultEntity> list = database.getCalculatorDao().getAll();
        if(list.size() != 2) {
            fail();
        }
    }
}
