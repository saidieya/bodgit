package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase2 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy("127.0.0.1:8008");
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		driver = new FirefoxDriver(capabilities);
		baseUrl = "http://10.2.212.4:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCase2() throws Exception {
		driver.get(baseUrl + "/1244/login.jsp");
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys("admin");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("mp_-812546491")).click();
		driver.findElement(By.cssSelector("span.GLTO14FJJ")).click();
		driver.findElement(By.id("c130790420-t1")).click();
		driver.findElement(By.id("in-c-1058540774-t1")).clear();
		driver.findElement(By.id("in-c-1058540774-t1")).sendKeys("test");
		driver.findElement(By.id("c527697293-t1")).click();
		driver.findElement(By.id("btn-ok-success")).click();
		driver.findElement(By.id("c-1150058004-t1")).click();
		driver.findElement(By.id("x-auto-216")).click();

		driver.findElement(By.id("c-1150058004-t1")).click();
		driver.findElement(By.id("btn-logout")).click();
		driver.findElement(By.id("btn-yes")).click();

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
