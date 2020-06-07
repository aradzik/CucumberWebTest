package io.cucumber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test_result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int test_id;
    private int result;
    private double test_time;
    private String date;
    private String last_step;

    public Test_result() {
    }


    public Test_result(int test_id, int result, double test_time, String date, String last_step) {
        this.test_id = test_id;
        this.result = result;
        this.test_time = test_time;
        this.date = date;
        this.last_step = last_step;
    }

    @Override
    public String toString() {
        return "Test_result{" +
                "ID=" + ID +
                ", test_id=" + test_id +
                ", result=" + result +
                ", test_time=" + test_time +
                ", date=" + date +
                ", last_step='" + last_step + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public double getTest_time() {
        return test_time;
    }

    public void setTest_time(double test_time) {
        this.test_time = test_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLast_step() {
        return last_step;
    }

    public void setLast_step(String last_step) {
        this.last_step = last_step;
    }
}
