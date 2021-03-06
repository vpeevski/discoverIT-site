package discoverita;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BrowserFirefox;
import util.RandomStringGen;

public class WrongEmail {
	public static void setup(){
		BrowserFirefox.driver.get("http://discoverita.com/testForm/");
	}
			
	public static void checkBlankJava() {
		checkBlank ("Java за начинаещи");
	}
	
	public static void checkBlankDataBase() {
		checkBlank ("Бази данни");
	}
	
	public static void checkBlankWebDesign() {
		checkBlank ("Web design (HTML5, CSS3, JavaScript)");
	}
	
	private static void checkBlank (String courseSelected) {
		WebElement nameField = BrowserFirefox.driver.findElement(By.id("firstname_id"));
		nameField.sendKeys(RandomStringGen.randomStringAllCharsNotEmpty());
		WebElement familyNameField = BrowserFirefox.driver.findElement(By.id("lastname_id"));
		familyNameField.sendKeys(RandomStringGen.randomStringAlphaNumericNotEmpty());
		
		WebElement selectCourseButton = BrowserFirefox.driver.findElement(By.id("course_id"));
		selectCourseButton.click();
		BrowserFirefox.driver.findElement(By.id("course_id")).sendKeys(courseSelected);
		
		WebElement eMailField = BrowserFirefox.driver.findElement(By.id("email_id"));
		eMailField.sendKeys(RandomStringGen.randomStringAlphaNumericNotEmpty());
		
		WebElement contactTypeButton = BrowserFirefox.driver.findElement(By.id("contact_type_id"));
		contactTypeButton.click();
		BrowserFirefox.driver.findElement(By.id("contact_type_id")).sendKeys("Се запиша");
		
		WebElement submitButton = BrowserFirefox.driver.findElement(By.xpath("//input[@name='send']"));
		submitButton.click();
		
		WebElement message = BrowserFirefox.driver.findElement(By.xpath("//span[@id='email_label_group']//span[@class='small-text help-block']"));
		String observedText = message.getText();
		assertEquals("* невалиден e-mail", observedText);
	}

}
