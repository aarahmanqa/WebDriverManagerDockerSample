import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class GoogleSearchTest {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = WebDriverManager.chromedriver().browserInDocker().enableVnc().enableRecording().create();
        driver.get("https://www.google.com");
        findElement(By.name("q")).sendKeys("Ahamed Abdul Rahman\n");
        findElement(By.tagName("h3")).click();
        driver.quit();
    }

    public static WebElement findElement(By by) {
        return waitFor(driver -> driver.findElement(by));
    }

    public static <T> T waitFor(Function<WebDriver,T> function) {
        return new WebDriverWait(driver,10).ignoring(NoSuchElementException.class).until(function);
    }
}
