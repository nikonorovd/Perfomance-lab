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

public class MailAuthorizationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMailAuthorization() throws Exception {
    wd.get("https://mail.ru/?from=logout&amp;ref=main");
    wd.findElement(By.name("clb831530")).click();
    wd.findElement(By.id("mailbox:login")).click();
    wd.findElement(By.id("mailbox:login")).clear();
    wd.findElement(By.id("mailbox:login")).sendKeys("89776153544");
    wd.findElement(By.xpath("//label[@id='mailbox:submit']/input")).click();
    wd.findElement(By.id("mailbox:password")).click();
    wd.findElement(By.id("mailbox:password")).clear();
    wd.findElement(By.id("mailbox:password")).sendKeys("lolipop99");
    wd.findElement(By.xpath("//label[@id='mailbox:submit']/input")).click();
  }

  @AfterMethod (alwaysRun = true)
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