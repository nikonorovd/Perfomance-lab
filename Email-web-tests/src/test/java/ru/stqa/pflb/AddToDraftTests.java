package ru.stqa.pflb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToDraftTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddToDraftTests() throws Exception {
    driver.get("https://e.mail.ru/inbox/?back=1");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='С вложениями'])[1]/following::span[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("//input[@value='dfgdfg']")).clear();
    driver.findElement(By.xpath("//input[@value='dfgdfg']")).sendKeys("dfgdfg");
    driver.findElement(By.name("Subject")).click();
    driver.findElement(By.name("Subject")).clear();
    driver.findElement(By.name("Subject")).sendKeys("fdgdfg");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Шаблоны'])[1]/following::div[6]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отправить'])[1]/following::span[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отправленные'])[1]/following::div[4]")).click();
  }

  @AfterClass(alwaysRun = true)
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
