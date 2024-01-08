package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        // Acilan sayfanin Title'inda 'otomasyon' gectigini test edin

        String expectedTitleIcerik = "otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title 'otomasyon' icermiyor, title testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }


        // acilan sayfanin url'inin otomasyon icerdigini test edin

        String expectedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }else{
            System.out.println("Url 'otomasyon' icermiyor, Url testi FAILED");
        }

        /*
        driver.getWindowHandle() : driver'in gittigi sayfanin Windowhandle degerini verir
        driver.getWindowHandles() : driver olusturulduktan sonra, test boyunca
                                    actigi tum sayfalarin WindowHandle degerlerini bir Set olarak verir
         */
        System.out.println(driver.getWindowHandle());
        // 32606ED97B60188D3B2EF589766513C9
        System.out.println(driver.getWindowHandles());
        // [32606ED97B60188D3B2EF589766513C9]



        System.out.println("======= Sayfa Kaynagi ========");
        System.out.println(driver.getPageSource());
        // Tum sayfa kaynagini dondurur,
        // sayfa kaynagi ile ilgili bir test istenirse, kaydedilip kullanilabilir



        Thread.sleep(3000); // java'dan gelir kodlari yazilan milisaniye kadar bekletir
        driver.close();
    }
}
