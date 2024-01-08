package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.testotomasyonu.com");
        // get(istenenUrl) ile ayni islemi yapar

        // youtube anasayfaya gidin
        driver.navigate().to("https://www.youtube.com");

        // title'in "YouTube" icerdigini test edin
        String expectedTitleIcerik = "YouTube";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Youtube title testi PASSED");
        }else {
            System.out.println("Youtube title testi FAILED");
        }

        // tekrar test otomasyonu ana sayfaya donun
        driver.navigate().back();

        // sayfa kaynaginin "Test Otomasyonu" icerdigini test edin

        String expectedSayfaIcerik ="Test Otomasyonu";
        String actualSayfaKaynagi = driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfaIcerik)){
            System.out.println("Test otomasyonu sayfa kaynagi testi PASSED");
        }else {
            System.out.println("Test otomasyonu sayfa kaynagi testi FAILED");
        }

        // bir daha youtube anasayfaya gidin
        driver.navigate().forward();

        // url'in https://www.youtube.com/ oldugunu test edin

        String expectedUrl = "https://www.youtube.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Youtube Url testi PASSED");
        }else{
            System.out.println("Youtube Url testi FAILED");
        }


        Thread.sleep(3000);
        driver.close();
    }
}
