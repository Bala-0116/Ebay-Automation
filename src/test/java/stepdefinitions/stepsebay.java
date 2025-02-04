package stepdefinitions;

import com.pages.EbayDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class stepsebay {

    WebDriver driver;  // Don't initialize it as null here
    EbayDetails ebay;  // Declare only, initialize later


    @Given("a user opens a ebay website")
    public void aUserOpensAEbayWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver(); // Initialize WebDriver properly
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        ebay = new EbayDetails(driver); // Initialize EbayDetails AFTER WebDriver
    }


    @When("he search the book")
    public void heSearchTheBook() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(ebay.searchbox)).sendKeys("Book");
        ebay.searchbtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item57841b8566\"]/div/div[1]/div/a/div/img")));
    }

    @And("adds the book to cart")
    public void addsTheBookToCart() {
        ebay.bookdetail.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String parentWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Wait for new tab

        // Get all window handles and switch to new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }

           String url =  driver.getCurrentUrl();
            System.out.println(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            js.executeScript("window.scrollBy(0, 500);");
         //   js.executeScript("arguments[0].scrollIntoView(true);", ebay.addtocartbtn);
            ebay.addtocartbtn.click();
          //  wait.until(ExpectedConditions.elementToBeClickable(ebay.addtocartbtn)).click();
        }
    }

    @Then("checks whether it's added to the cart")
    public void checksWhetherItSAddedToTheCart() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(ebay.cartcountindicator.getText(),"1");
        driver.quit();
    }
}
