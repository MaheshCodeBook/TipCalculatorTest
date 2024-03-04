package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TipCalculatorFunctionalitySteps {

    public WebDriver driver ;
    WebDriverWait wait;

    @Before
    public void setUp(){
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromediver122\\chromedriver-win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am on tip calculater page")
    public void  iAmOntheCalculaterPage(){
        driver.get("https://qatipcalc.ccbp.tech/");
    }

    @When("I clear tip percentage input filed make sure its zero")
    public void clearTipPercebtageFiled(){
        driver.findElement(By.id("percentageTip")).clear();
    }

    @And("I click on caluculate button")
    public void clickOnCalculaterButton(){
        driver.findElement(By.id("calculateButton")).click();
    }

    @Then("An error message 'Please Enter a Valid Input.' can be visible")
    public void errorMsgWithOutInput(){
        String errorText = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(errorText,"Please Enter a Valid Input.");
    }

    @When("I entered invalid input")
    public void enterInvalidInput(){
        driver.findElement(By.id("percentageTip")).sendKeys("10f");
    }
    @When("I entered bill amount")
    public void enteredBillAmount(){
        driver.findElement(By.id("billAmount")).sendKeys("1000");
    }
    @And("I ented tip percentage")
    public void enterTipPercentage(){
        driver.findElement(By.id("percentageTip")).sendKeys("15");
    }

    @Then("I can see bill amount and tip amount")
    public void billAmountAndTotalAmount(){
        String tipAmout = driver.findElement(By.id("tipAmount")).getText();
        String totalAmount = driver.findElement(By.id("totalAmount")).getText();

        Assert.assertEquals(tipAmout,"150.00");
        Assert.assertEquals(totalAmount,"1150.00");

    }









}
