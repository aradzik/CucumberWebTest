package io.cucumber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue
    private int id;
    private String test_name;
    private int id_tool_type;
    private String browser;


    public Test() {
    }

    public Test(int id, String test_name, int id_tool_type, String browser) {
        this.id = id;
        this.test_name=  test_name;
        this.id_tool_type = id_tool_type;
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", test_name='" + test_name + '\'' +
                ", id_tool_type=" + id_tool_type +
                ", browser='" + browser + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getId_tool_type() {
        return id_tool_type;
    }

    public void setId_tool_type(int id_tool_type) {
        this.id_tool_type = id_tool_type;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
