package day04_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_XPath {

    public static void main(String[] args) throws InterruptedException {

        //1-  bir class olusturun
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title icerik testi PASSED");
        }else System.out.println("Title icerik testi PASSED");

        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//li[@class='has-sub'])[5]")).click();
        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minDegerKutusu = driver.findElement(By.xpath("//input[@name='min']"));
        minDegerKutusu.clear();
        minDegerKutusu.sendKeys("40");

        WebElement maxDegerKutusu = driver.findElement(By.xpath("//input[@name='max']"));
        maxDegerKutusu.clear();
        maxDegerKutusu.sendKeys("200");

        driver.findElement(By.xpath("//button[@name='button']")).click();
        //8-  filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunlerListesi =
                driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int actualBulunanUrunSayisi = bulunanUrunlerListesi.size();

        if (actualBulunanUrunSayisi > 0){
            System.out.println("Bulunan urun testi PASSED");
        }else System.out.println("Bulunan urun testi FAILED");
        //10-Ilk urunu tiklayin

        bulunanUrunlerListesi.get(0).click();
        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement urunFiyatElementi = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        String urunFiyatiStr= urunFiyatElementi.getText().replaceAll("\\D","");
        int urunFiyatiInt = Integer.parseInt(urunFiyatiStr)/100;

        if (urunFiyatiInt>40 && urunFiyatiInt<200){
            System.out.println("Ilk urun fiyat testi PASSED");
        }else System.out.println("Ilk urun fiyat testi FAILED");

        //12-Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}
