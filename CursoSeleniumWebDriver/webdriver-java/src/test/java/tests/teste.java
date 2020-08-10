package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class teste {
    @Test
    public void abreNavegado(){
        System.setProperty("webDriver.chrome.driver", "C:\\Windows\\chomedriver");
        WebDriver navegador = new ChromeDriver();
    }


}
