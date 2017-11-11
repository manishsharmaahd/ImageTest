package com.ffdc.controller;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;


public class AWSControllerTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	Thread.sleep(30000);
    driver = new HtmlUnitDriver();
    		//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
			 System.setProperty("webdriver.chrome.driver","C:\\FFDC\\chromedriver.exe");
 	//driver = new ChromeDriver();
 driver = new HtmlUnitDriver(true);
    baseUrl = "http://127.0.0.1/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAWSController() throws Exception {
    driver.get(baseUrl + "/");
Thread.sleep(3000);
    driver.findElement(By.xpath("(//input[@id='username'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@id='username'])[3]")).sendKeys("manish");
    driver.findElement(By.xpath("(//input[@id='password'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@id='password'])[3]")).sendKeys("bharat@1234");
    driver.findElement(By.xpath("(//div[@id='loginModal']/div/div/div/div/div/section/div/div/div[2]/div/form/fieldset[3]/div[2])[3]")).click();
    driver.findElement(By.xpath("(//select[@id='city'])[3]")).click();

Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("(//select[@id='city'])[3]"))).selectByVisibleText("Ahmedabad");
    driver.findElement(By.xpath("(//option[@value='ahd'])[3]")).click();
    driver.findElement(By.xpath("(//select[@id='clinic'])[3]")).click();
Thread.sleep(1000);
    new Select(driver.findElement(By.xpath("(//select[@id='clinic'])[3]"))).selectByVisibleText("sg_ahd");
    driver.findElement(By.cssSelector("option[value=\"string:sg_ahd\"]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
    driver.findElement(By.id("loadMemberId")).clear();
   Thread.sleep(1000);
   driver.findElement(By.id("loadMemberId")).sendKeys("3056");
    driver.findElement(By.id("loadMemberId")).clear();

      driver.findElement(By.id("loadMemberId")).sendKeys("3056");
		WebElement element= driver.findElement(By.id("btnLoadMember"));

 // Configure the Action
Actions action = new Actions(driver);

//Focus to element
action.moveToElement(element).perform();

// To click on the element
action.moveToElement(element).click().perform();/* /html/body/nav/div/div[2]/div/ul[1]/li[5] */
   Thread.sleep(4000);




   System.out.println( driver.findElement(By.id("projectinput1")).getText().trim());
	try {
		driver.findElement(By.cssSelector("i.icon-plus4")).click();
	}
	catch(Exception e )
	{
	}
	Thread.sleep(4000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
