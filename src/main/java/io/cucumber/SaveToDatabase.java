package io.cucumber;

import io.cucumber.model.Test;
import io.cucumber.model.Test_result;
import io.cucumber.model.Tool;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToDatabase {
    private static SessionFactory factory;

    public SaveToDatabase() throws IOException {
    }

    public void saveFile(float duration, String step, String date) throws IOException {
        FileWriter file = new FileWriter("result.txt", true);
        BufferedWriter result = new BufferedWriter(file);
        String time = String.valueOf(duration);
        result.write(time + "," + step + ", " + date + "\n");
        result.close();
    }

    public void saveToDatabase(int test_id, float time, String date, String last_step) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        int result = 0;

        SaveToDatabase saveToDatabase = new SaveToDatabase();

        if (last_step.equals("4. Exit browser") || last_step.equals("8. Log out and exit browser")) result = 1;
        //saveToDatabase.addTool(2,"Cucumber", "");
        //saveToDatabase.addTest(10,"eng_moodle_S_F",2, "Firefox");
        saveToDatabase.addTestResult(test_id, result, time, date, last_step);
    }

    public Integer addTestResult(int test_id, int result, double test_time, String date, String last_step) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer testResultID = null;

        try {
            tx = session.beginTransaction();
            Test_result test_result = new Test_result(test_id, result, test_time, date, last_step);
            testResultID = (Integer) session.save(test_result);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return testResultID;
    }

    public Integer addTest(int id, String test_name, int id_tool_type, String browser) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer testID = null;

        try {
            tx = session.beginTransaction();
            Test test = new Test(id, test_name, id_tool_type, browser);
            testID = (Integer) session.save(test);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return testID;
    }

    public Integer addTool(int ID, String tool_name, String description) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer toolID = null;

        try {
            tx = session.beginTransaction();
            Tool tool = new Tool(ID, tool_name, description);
            toolID = (Integer) session.save(tool);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return toolID;
    }
}
