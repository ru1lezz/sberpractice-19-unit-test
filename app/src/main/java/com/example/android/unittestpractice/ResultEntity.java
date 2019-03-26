package com.example.android.unittestpractice;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

@Entity
public class ResultEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private double result;

    public ResultEntity() {
    }

    public ResultEntity(double result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntity that = (ResultEntity) o;
        return id == that.id &&
                Double.compare(that.result, result) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, result);
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id=" + id +
                ", result=" + result +
                '}';
    }
}
