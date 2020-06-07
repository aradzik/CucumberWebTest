package io.cucumber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tool {

    @Id
    @GeneratedValue
    private int ID;
    private String tool_name;
    private String description;

    public Tool(int ID, String tool_name, String description) {
        this.ID = ID;
        this.tool_name = tool_name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "ID=" + ID +
                ", tool_name='" + tool_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTool_name() {
        return tool_name;
    }

    public void setTool_name(String tool_name) {
        this.tool_name = tool_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
