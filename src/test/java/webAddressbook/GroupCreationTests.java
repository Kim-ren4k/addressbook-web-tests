package webAddressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //driver.get("https://www.udemy.com/");

        //WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        //element.sendKeys("Java", Keys.ENTER); // написать "Java", нажать ENTER


        //try {
        //driver.get("https://crossbowsertesting.github.io/drag-and-drop");
        //Thread.sleep(2000); //задержка
        //WebElement element = driver.findElement(By.xpath()


        // } catch (InterruptedException e) {

        // e.printStackTrace();
        // }

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));


        try {
            driver.get("http://localhost/addressbook/"); //открыли сайт
            Thread.sleep(2000);                // подождали 2 сек

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li")); // записли элементы
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-page']/ul/li")); // записали странцы

            String text = elements.get(6).getText(); // после обновления страницы, забераем текст
            System.out.println(text); // вывод в терминале для просмотра

            pages.get(2).click(); // переключить страницу страницу
            wait.until(ExpectedConditions.stalenessOf(elements.get(6))); // ожидание, ждем пока продадет
            elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li")); // загружена новая инфа, перезаписываем elemets

            text = elements.get(6).getText();
            System.out.println(text); // вывод в терминале для просмотра


        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.quit(); // Практика закрытия драйвера чтобы не висел
        }


    }
}