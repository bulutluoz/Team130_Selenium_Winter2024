package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        // driver.findElement(By.id("sub-btn")).click();
        driver.findElement(By.xpath("//*[@id = 'sub-btn']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        // WebElement removeButonu = driver.findElement(By.className("remove-btn"));
        WebElement removeButonu = driver.findElement(By.xpath("//*[@class='remove-btn']"));
        if (removeButonu.isDisplayed()){
            System.out.println("Remove butonu gorunme testi PASSED");
        }else {
            System.out.println("Remove butonu gorunme testi FAILED");
        }


        //4- Remove tusuna basin

        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        // WebElement addRemoveYazielementi = driver.findElement(By.tagName("h2"));
        WebElement addRemoveYazielementi = driver.findElement(By.xpath("//h2"));

        if (addRemoveYazielementi.isDisplayed()){
            System.out.println("Add/Remove gorunme testi PASSED");
        }else {
            System.out.println("Add/Remove gorunme testi FAILED");
        }


        driver.quit();

    }
}
