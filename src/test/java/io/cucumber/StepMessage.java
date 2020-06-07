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


public class StepMessage {

    long millisActualTime;
    double time = 0; //test_time
    String step; //last_step
    String date; //date
    private WebDriver driver;
    boolean doContinue = true;

    SaveToDatabase s = new SaveToDatabase();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public StepMessage() throws IOException {
    }


    @Given("open the Chrome and go to Moodle")
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
            step = "1. Open the Chrome and go to Moodle";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            s.saveToDatabase(5, (float) time, date, step);
            doContinue = false;
        }
    }

    @When("enter the Username and Password")
    public void enter_the_Username_and_Password() throws Throwable {
        if (doContinue) {
            String login = "login";
            String password = "passwd";
            try {
                WebElement username = driver.findElement(By.name("username"));
                username.sendKeys(login);
                WebElement passwd = driver.findElement(By.name("password"));
                passwd.sendKeys(password);
                passwd.submit();
            } catch (Exception e) {
                step = "2. Enter the Username and Password";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("send a message to Magdalena saying Cucumber Test")
    public void sand_A_Message_To_Magdalena_Psujek_Saying_Cucumber_Test() throws Throwable {
        if (doContinue) {
            try {
                WebElement message = driver.findElement(By.id("nav-message-popover-container"));
                message.click();
                message = driver.findElement(By.className("newmessage-link"));
                message.click();
                message = driver.findElement(By.id("searchtext"));
                message.sendKeys("Magdalena Ewa Psujek");
                message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div/div/div/div/div[1]/div[4]/div/div[2]/div"));
                message.click();
                message = driver.findElement(By.xpath(" /html/body/div[2]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[3]/div[1]/div[1]/textarea"));
                message.sendKeys("Cucumber test");
                message = driver.findElement(By.className("send-button-container"));
                message.click();
            } catch (Exception e) {
                step = "3. Send a message to Magdalena saying Cucumber Test";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("log out")
    public void log_Out() throws IOException {
        if (doContinue) {
            try {
                WebElement logout = driver.findElement(By.id("action-menu-1-menubar"));
                logout.click();
                logout = driver.findElement(By.id("actionmenuaction-6"));
                logout.click();
            } catch (Exception e) {
                step = "4. Log out";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("login to Magdalena account")
    public void loginToMagdalenaPsujekAccount() throws IOException {
        String login = "login";
        String password = "passwd";
        if (doContinue) {
            try {
                driver.get("https://moodle1.cs.pollub.pl/");
                WebElement username = driver.findElement(By.name("username"));
                username.sendKeys(login);
                WebElement passwd = driver.findElement(By.name("password"));
                passwd.sendKeys(password);
                passwd.submit();
            } catch (Exception e) {
                step = "5. Login to Magdalena account";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("checking messages from the first account")
    public void checkingMessagesFromTheFirstAccount() throws IOException {
        if (doContinue) {
            try {
                WebElement check = driver.findElement(By.id("nav-message-popover-container"));
                check.click();
                boolean isMessage = driver.findElement(By.className("unread-count-container")).isDisplayed();
                if (isMessage) {
                    check = driver.findElement(By.className("unread-count-container"));
                    check.click();
                }
            } catch (Exception e) {
                step = "6. Checking messages from the first account";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("delete last message")
    public void deleteLastMessage() throws IOException {
        if (doContinue) {
            try {
                WebElement delete = driver.findElement(By.className("actions"));
                delete.click();
                delete = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[2]/div[21]"));
                delete.click();
                delete = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[3]/div[2]/button"));
                delete.click();
            } catch (Exception e) {
                step = "7. Delete last message";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @And("log out and exit browser")
    public void logOutAndExitBrowser() throws IOException {
        if (doContinue) {
            try {
                log_Out();
                driver.quit();
            } catch (Exception e) {
                step = "8. Log out and exit browser";
                float duration = System.currentTimeMillis() - millisActualTime;
                time = duration / 1000;
                s.saveToDatabase(5, (float) time, date, step);
                doContinue = false;
            }
        }
    }

    @Then("print time")
    public void printDuringTime() throws IOException {
        if (doContinue) {
            step = "8. Log out and exit browser";
            float duration = System.currentTimeMillis() - millisActualTime;
            time = duration / 1000;
            System.out.println("Czas testu: " + time);
            System.out.println("Data: " + date);
            s.saveFile((float) time, step, date);
            s.saveToDatabase(5, (float) time, date, step);
        }
    }
}
