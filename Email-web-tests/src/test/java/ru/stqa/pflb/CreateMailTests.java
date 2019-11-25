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

public class CreateMailTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateMail() throws Exception {
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
    wd.findElement(By.xpath("//img[contains(@src,'https://img.imgsmail.ru/static.promo/logo/logo.svg')]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='С вложениями'])[1]/following::span[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    wd.findElement(By.xpath("//input[@value='nikonorovds@yandex.ru']")).clear();
    wd.findElement(By.xpath("//input[@value='nikonorovds@yandex.ru']")).sendKeys("nikonorovds@yandex.ru");
    wd.findElement(By.name("Subject")).click();
    wd.findElement(By.name("Subject")).clear();
    wd.findElement(By.name("Subject")).sendKeys("Tema");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Подпись'])[1]/following::div[3]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Шаблоны'])[1]/following::div[5]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сверните черновик, если нужноуточнить информациюв другом письме'])[1]/following::span[3]")).click();
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
