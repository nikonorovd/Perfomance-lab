package ru.stqa.pflb;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToDraftTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddToDraft() throws Exception {
    wd.get("https://e.mail.ru/inbox/?back=1");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='С вложениями'])[1]/following::span[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    wd.findElement(By.xpath("//input[@value='dfgdfg']")).clear();
    wd.findElement(By.xpath("//input[@value='dfgdfg']")).sendKeys("dfgdfg");
    wd.findElement(By.name("Subject")).click();
    wd.findElement(By.name("Subject")).clear();
    wd.findElement(By.name("Subject")).sendKeys("fdgdfg");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Шаблоны'])[1]/following::div[6]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отправить'])[1]/following::span[3]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отправленные'])[1]/following::div[4]")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
