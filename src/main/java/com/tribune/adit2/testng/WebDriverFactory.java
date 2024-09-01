package com.tribune.adit2.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tribune.adit2.util.Configurator;


class WebDriverFactory 
{
	static WebDriver createInstance(String browserName) {
		WebDriver driver = null;
		if (browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
			return driver;
		}
		if (browserName.toLowerCase().contains("safari")){
			driver = new SafariDriver();
			return driver;
		}
		if (browserName.toLowerCase().contains("internet")) {
			System.setProperty("webdriver.ie.driver", Configurator.getConfig().get("IE_DRIVER_PATH"));
			driver = new InternetExplorerDriver();
			return driver;
		}
		if (browserName.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", Configurator.getConfig().get("CHROME_DRIVER_PATH"));
			ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeOptions.addArguments("test-type","disable-extensions");
			chromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			chromeOptions.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
			//chromeOptions.addArguments("--headless"); // only if you are ACTUALLY running headless
			chromeOptions.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
			//chromeOptions.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
			//chromeOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
			//chromeOptions.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
			chromeOptions.addArguments("--disable-gpu");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			return driver;
		}
		return driver;
	}
}
