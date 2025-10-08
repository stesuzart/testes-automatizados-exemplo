package br.stesuzart.testecomspring.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest {
    public WebDriver driver;

    @Test
    void testandoDriver() {

        /*
        * Baixar a versão do ChromeDriver compatível com a versão do Chrome instalada na máquina
        * https://googlechromelabs.github.io/chrome-for-testing/#stable
        * e substiruir o chromedriver na pasta do projeto
        * e alterar o caminho abaixo
        * */
        System.setProperty("webdriver.chrome.driver", "/caminho-da-sua-maquina/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://google.com");

        String titulo = driver.getTitle();
        Assertions.assertEquals("Google", titulo);

        driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        String value = searchBox.getAttribute("value");
        Assertions.assertEquals("Selenium", value);

        driver.quit();
    }
}