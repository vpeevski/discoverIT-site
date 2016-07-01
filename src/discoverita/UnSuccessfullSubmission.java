package discoverita;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BrowserFirefox;
import util.RandomStringGen;

public class UnSuccessfullSubmission {
	public static void open(){
		BrowserFirefox.driver.get("http://discoverita.com/testForm/");
	}
			
	public static void emptyBox() {
		WebElement nameField = BrowserFirefox.driver.findElement(By.id("firstname_id"));
		nameField.sendKeys(RandomStringGen.randomStringAlphaNumericNotEmpty());
		
		WebElement familyNameField = BrowserFirefox.driver.findElement(By.id("lastname_id"));
		familyNameField.sendKeys(RandomStringGen.randomStringAlphaNumericNotEmpty());
		
		WebElement selectCourseButton = BrowserFirefox.driver.findElement(By.id("course_id"));
		selectCourseButton.click();
		
		BrowserFirefox.driver.findElement(By.id("course_id")).sendKeys("Java за начинаещи");
		
		WebElement eMailField = BrowserFirefox.driver.findElement(By.id("email_id"));
		eMailField.sendKeys("svet1981@abv.bg");
		
		WebElement contactTypeButton = BrowserFirefox.driver.findElement(By.id("contact_type_id"));
		contactTypeButton.click();
		
		BrowserFirefox.driver.findElement(By.id("contact_type_id")).sendKeys("Попитам");
		
		WebElement submitButton = BrowserFirefox.driver.findElement(By.xpath("//input[@name='send']"));
		submitButton.click();
		
		WebElement message = BrowserFirefox.driver.findElement(By.xpath("//span[@id='message_label_group']//span[@class='small-text help-block']"));
		String observedText = message.getText();
		assertEquals("* въведете текст", observedText);
		
	}

}
