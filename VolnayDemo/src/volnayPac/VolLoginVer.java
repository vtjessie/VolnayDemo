package volnayPac;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class VolLoginVer {
	public static WebDriver driver;
	
  @Test(dataProvider = "userPassword")
  public void f(String n, String s) throws InterruptedException {
	  
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("email")).sendKeys(n);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(s);
	  driver.findElement(By.className("login100-form-btn")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("infotab")).click();

  }

  @DataProvider
  public Object[][] userPassword() {
    return new Object[][] {
      new Object[] { "vt.jessie@gmail.com", "Divine123" },
  //    new Object[] { "2", "b" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	driver = Util.setgecodriver();
	driver.get(Util.BASE_URL);
  }

  @AfterTest
  public void afterTest() {
  }

}
