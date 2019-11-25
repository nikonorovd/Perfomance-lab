package ru.stqa.pflb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateMailTests {
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
  public void testCreateMailTests() throws Exception {
    driver.get("https://mail.ru/?from=logout&amp;ref=main");
    driver.findElement(By.name("clb831530")).click();
    driver.findElement(By.id("mailbox:login")).click();
    driver.findElement(By.id("mailbox:login")).clear();
    driver.findElement(By.id("mailbox:login")).sendKeys("89776153544");
    driver.findElement(By.xpath("//label[@id='mailbox:submit']/input")).click();
    driver.findElement(By.id("mailbox:password")).click();
    driver.findElement(By.id("mailbox:password")).clear();
    driver.findElement(By.id("mailbox:password")).sendKeys("lolipop99");
    driver.findElement(By.xpath("//label[@id='mailbox:submit']/input")).click();
    driver.findElement(By.xpath("//img[contains(@src,'https://img.imgsmail.ru/static.promo/logo/logo.svg')]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='С вложениями'])[1]/following::span[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("//input[@value='nikonorovds@yandex.ru']")).clear();
    driver.findElement(By.xpath("//input[@value='nikonorovds@yandex.ru']")).sendKeys("nikonorovds@yandex.ru");
    driver.findElement(By.name("Subject")).click();
    driver.findElement(By.name("Subject")).clear();
    driver.findElement(By.name("Subject")).sendKeys("Tema");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Подпись'])[1]/following::div[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Шаблоны'])[1]/following::div[5]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сверните черновик, если нужноуточнить информациюв другом письме'])[1]/following::span[3]")).click();
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
