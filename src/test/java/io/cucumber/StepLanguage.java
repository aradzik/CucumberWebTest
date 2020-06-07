package io.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepLanguage {
    long millisActualTime;
    double time = 0; //test_time
    String step; //last_step
    String date; //date
    private WebDriver driver;

    SaveToDatabase s = new SaveToDatabase();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public StepLanguage() throws IOException {
    }

    @Given("open the Chrome and launch the application")
    public void open_the_Chrome_and_launch_the_application() throws Throwable {
        date = format.format(new Date());
        millisActualTime = System.currentTimeMillis();
        try {
            System.setProperty("webdriver.chrome.driver", "D:/Dokumenty/IdeaProjects/CucumberWebTest/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://moodle1.cs.pollub.pl/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Nie udalo sie z Open the Chrome and launch the application");

            step = "1. Open the Chrome and launch the application";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            s.saveToDatabase(4, (float) time, date, step);
        }
    }

    @When("change to English")
    public void change_to_English() throws IOException {
        try {
            WebElement change = driver.findElement(By.xpath("/html/body/div[1]/nav/ul[1]/li[5]/a"));
            change.click();
            change = driver.findElement(By.xpath("/html/body/div[1]/nav/ul[1]/li[5]/div/a[2]"));
            change.click();

        } catch (Exception e) {
            System.out.println("Nie udalo sie z Change to English");
            step = "2. Change to English";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            s.saveToDatabase(4, (float) time, date, step);
        }
    }

    @When("check language")
    public void check_language() throws IOException {
        try {
            WebElement check = driver.findElement(By.id("instance-896-header"));
            check.click();
            String txt = driver.findElement(By.id("instance-896-header")).getText();
            assertEquals(txt, "Login");

        } catch (Exception e) {
            System.out.println("Nie udalo sie z Check language");
            step = "3. Check language";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            s.saveToDatabase(4, (float) time, date, step);
        }
    }

    @And("exit browser")
    public void exitBrowser() throws IOException {
        try {
            driver.quit();

        } catch (Exception e) {
            System.out.println("Nie udalo sie z Exit browser");
            step = "4. Exit browser";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            s.saveToDatabase(4, (float) time, date, step);
        }
    }

    @Then("print during time")
    public void printDuringTime() throws IOException {
        step = "4. Exit browser";
        float duration = System.currentTimeMillis() - millisActualTime;
        time = duration / 1000;
        System.out.println("Czas testu: " + time);
        System.out.println("Data: " + date);
        s.saveFile((float) time, step, date);
        s.saveToDatabase(4, (float) time, date, step);

    }
}
