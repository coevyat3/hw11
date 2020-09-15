import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestingC {
  static WebDriver driver;
  static NgWebDriver ngWebDriver;

    @BeforeClass
    public static void BeforeAll(){
        driver=DriverSingelton.getDriverInstance();
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    //1.1
    public void test_implicitWait(){
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driver.findElement(By.id("checkbox")).isDisplayed();
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.id("message")).isDisplayed();

    }
    @Test
    //1.2
    public void test_thread() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("finish1")).isDisplayed();

    }
    @Test
    //1.3
    public void Test03_ExplicitWait() {
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driver.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        String output = driver.findElement(By.id("finish2")).getText();
        Assert.assertEquals(output, "This is a new element");

    }

    @Test
    public void test_02(){
        driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
        ngWebDriver.waitForAngularRequestsToFinish();
        WebElement name=driver.findElement(By.xpath("/html/body/label[1]/input"));
        name.clear();
        name.sendKeys("evyatar");
        Assert.assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"), "evyatar");

    }
    @Test
    public void test_alert() {
        driver.navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.findElement(By.id("MyAlert")).click();
        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        al.accept();
    }
    @Test
    public void test_prompt(){
        driver.navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.findElement(By.id("MyPrompt")).click();
        Alert al=driver.switchTo().alert();
        al.sendKeys("evyatar");
        al.accept();
        String str="evyatar";
        Assert.assertEquals(driver.findElement(By.id("output")).getText(),str);
    }
    @Test
    public void test_confirm_box(){
        driver.navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.findElement(By.id("MyConfirm")).click();
        Alert al=driver.switchTo().alert();
        al.accept();
        String s="Confirmed";
        Assert.assertEquals(driver.findElement(By.id("output")).getText(),s);

    }

    //4-pageLoadTimeout - להמתין עד שהעמוד יטען במלאו לפני זריקת שגיאה

  @Test
    public void test_util(){
      System.out.println(Util.getOS());
      Util.getDate();
  }
  @Test
    public void test_pom()  {
        driver.navigate().to("https://dgotlieb.github.io/WebCalculator");
      System.out.println(driver.findElement(By.id(Constant.SEVEN)).getSize());
      System.out.println(driver.findElement(By.id("six")).isDisplayed());
      POM.get_one();
      POM.pressPlus();
      POM.get_one();
      POM.pressEquals();
      String expectedResult = "2";
      Assert.assertEquals(expectedResult, POM.getResult());
  }
  @AfterClass
    public void close(){
        driver.close();

  }

}


