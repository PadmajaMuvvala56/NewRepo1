package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_demo {

	WebDriver driver;

	@BeforeTest
	public void setUpTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearch() throws InterruptedException {

		// System.setProperty(webdriver.chrome.driver,"..path of driver exe...")

		// not needed above or WebDriverManager also for latest build of Se4 bcos of
		// SeleniumManager inbuilt tool
		// which automatically configures from the web

		// WebDriverManager.chromedriver.setup();
		// WebDriverManager.chromedriver.driverVersion("92.0").setup();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("automation step by step" + Keys.ENTER);

		// driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("automation
		// step by step" + Keys.ESCAPE);

		// Thread.sleep(2000);
		// driver.findElement(By.name("btnk")).click();
		// driver.navigate().to("https://automationstepbystep.com");
		driver.get("https://automationstepbystep.com");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}
}
