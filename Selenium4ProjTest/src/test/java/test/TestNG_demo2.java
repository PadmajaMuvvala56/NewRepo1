package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_demo2 {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void setUpTest(@Optional String browserName) throws Exception {
		System.out.println("browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		// System.out.println("driver");
		else if (browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browserName.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
	}

	@Test
	public void googleSearch2() throws InterruptedException {
		System.out.println("inside googlesearch2");
		// System.setProperty(webdriver.chrome.driver,"..path of driver exe...")

		// not needed above or WebDriverManager also for latest build of Se4 bcos of
		// SeleniumManager inbuilt tool
		// which automatically configures from the web

		// WebDriverManager.chromedriver.setup();
		// WebDriverManager.chromedriver.driverVersion("92.0").setup();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

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

	@Test
	public void googleSearch3() {
		System.out.println("inside googlesearch3");
	}

	@AfterTest
	public void tearDownTest() {
		try {
			driver.close();
			// driver.quit();
			// commented bcos quit should not be used when doing multi browser testing or
			// parallel testing which closes the sessions running and gives exception

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
