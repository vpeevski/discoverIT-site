package discoverita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.BrowserFirefox;
import util.RandomStringGen;
import static org.junit.Assert.assertEquals;

public class SuccessfullSubmission {

		public static void setup(){
			BrowserFirefox.driver.get("http://discoverita.com/testForm/");
		}
				
		public static void checkBlankJava() {			
			check("Java за начинаещи", "Запитването Ви относно курс по Java за начинаещи е прието успешно.");
		}
		
		public static void checkBlankDataBase() {
			check("Бази данни", "Запитването Ви относно курс по Бази данни е прието успешно.");
		}
		
		public static void checkBlankWebDesign() {
			check("Web design (HTML5, CSS3, JavaScript)", "Запитването Ви относно курс по Web design (HTML5, CSS3, JavaScript) е прието успешно.");
		}
		
		private static void check (String courseDisplay, String messageDisplay) {
			WebElement nameField = BrowserFirefox.driver.findElement(By.id("firstname_id"));
			nameField.sendKeys(RandomStringGen.randomStringAllCharsNotEmpty());
			
			WebElement familyNameField = BrowserFirefox.driver.findElement(By.id("lastname_id"));
			familyNameField.sendKeys(RandomStringGen.randomStringAlphaNumericNotEmpty());
			
			WebElement selectCourseButton = BrowserFirefox.driver.findElement(By.id("course_id"));
			selectCourseButton.click();
			
			BrowserFirefox.driver.findElement(By.id("course_id")).sendKeys(courseDisplay);
			
			WebElement eMailField = BrowserFirefox.driver.findElement(By.id("email_id"));
			eMailField.sendKeys("svet1981@abv.bg");
			
			WebElement contactTypeButton = BrowserFirefox.driver.findElement(By.id("contact_type_id"));
			contactTypeButton.click();
			
			BrowserFirefox.driver.findElement(By.id("contact_type_id")).sendKeys("Се запиша");
			
			WebElement submitButton = BrowserFirefox.driver.findElement(By.xpath("//input[@name='send']"));
			submitButton.click();
			
			WebElement message = BrowserFirefox.driver.findElement(By.xpath("//form[@id='contact_form']//div[@class='alert alert-success help-block']"));
			String observedText = message.getText();
			assertEquals(messageDisplay, observedText);
		}
	}


