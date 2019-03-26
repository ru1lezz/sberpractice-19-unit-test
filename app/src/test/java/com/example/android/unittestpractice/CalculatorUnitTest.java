package com.example.android.unittestpractice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {

    private static double DELTA = 0.01;

    private Calculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(calculator.add(4,4), 8, DELTA);
        assertEquals(calculator.add(-50, 50), 0, DELTA);
        assertEquals(calculator.add(-4, -12), -16, DELTA);
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(4,4), 0, DELTA);
        assertEquals(calculator.subtract(50, -50), 100, DELTA);
        assertEquals(calculator.subtract(-4, -12), 8, DELTA);
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(4,4), 16, DELTA);
        assertEquals(calculator.multiply(-50, 50), -2500, DELTA);
        assertEquals(calculator.multiply(-4, -12), 48, DELTA);
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(4,4), 1, DELTA);
        assertEquals(calculator.divide(2500, -50), -50, DELTA);
        thrown.expect(ArithmeticException.class);
        assertEquals(calculator.divide(16, 0), 0, DELTA);
    }

    @Test
    public void testSqrt() {
        try {
            Method method = Calculator.class.getDeclaredMethod("sqrt", double.class);
            method.setAccessible(true);
            assertEquals((double) method.invoke(calculator, 100), 10, DELTA);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
