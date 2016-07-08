package discoverita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.BrowserFirefox;
import static org.junit.Assert.assertEquals;

public class Discoverita {
		
	public static void open() {
		BrowserFirefox.driver.get("http://discoverita.com/");
	}
	
	public static void checkBarButtons() {
		WebElement contactButton = BrowserFirefox.driver.findElement(By.xpath("//div[@class='nav-bar-main']//a[@href='contact.php']"));
		contactButton.click();
		WebElement message = BrowserFirefox.driver.findElement(By.xpath("//div[@class='container']//div[@class='contact-heading']//h3"));
		String observedText = message.getText();
		assertEquals("Свържете се с нас", observedText);
		WebElement courseButton = BrowserFirefox.driver.findElement(By.xpath("//div[@class='nav-bar-main']//a[@href='courses.php']"));
		courseButton.click();
		WebElement messageCourse = BrowserFirefox.driver.findElement(By.xpath("//div[@class='container']//h6//span[@class='page-active']"));
		String courseText = messageCourse.getText();
		assertEquals("КУРСОВЕ", courseText);
		WebElement contactButton1 = BrowserFirefox.driver.findElement(By.xpath("//div[@class='nav-bar-main']//a[@href='contact.php']"));
		contactButton1.click();
	}
}