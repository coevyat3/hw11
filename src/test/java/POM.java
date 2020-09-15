import org.openqa.selenium.By;

public class POM {
public static void get_one() {
    DriverSingelton.getDriverInstance().findElement(By.id("one")).click();
}
    public static void pressPlus() {
    DriverSingelton.getDriverInstance().findElement(By.id("add")).click();

    }

    public static void pressEquals() {
        DriverSingelton.getDriverInstance().findElement(By.id("equal")).click();
    }

    public static String getResult() {
        return DriverSingelton.getDriverInstance().findElement(By.id("screen")).getText();
    }
}

