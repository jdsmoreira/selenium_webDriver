package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String AUTOMATE_USERNAME = "jefersonduarteso1";
    public static final String AUTOMATE_ACCESS_KEY = "zqywqpvgqZ2LKeVCw5w2";
    public static final String URLBrowserStack = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        //Abrindo o navegador
        System.setProperty("webDriver.chrome.driver", "C:\\Windows\\chomedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.manage().window().maximize();

        return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "60.0");
        caps.setCapability("os", "Windows");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URLBrowserStack), caps);
            navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            navegador.get("http://www.juliodelima.com.br/taskit");
            navegador.manage().window().maximize();

        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL " + e.getMessage());
        }



        return navegador;
    }


}
