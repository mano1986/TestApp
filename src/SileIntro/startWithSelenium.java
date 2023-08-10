package SileIntro;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class startWithSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']/parent::label/parent::div/input")).sendKeys("manoranjan.bhoi@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text()='Results']/ancestor::div[4]/following-sibling::div[1]/descendant::h2/a")).click();
		Set<String> wnd=driver.getWindowHandles();
		Iterator<String> itr=wnd.iterator();
		String parentwnd=itr.next();
		String child=itr.next();
		driver.switchTo().window(child);
		WebElement wb = driver.findElement(By.xpath("//span[text()='Without Exchange']/ancestor::div[2]/following-sibling::div/div/span"));
		System.out.println(parent);
		System.out.println(parentwnd);
		System.out.println(child);
		System.out.println(wb.getText());
		driver.switchTo().window(parent);
		
		//System.out.println(driver.getTitle());
	}

}
