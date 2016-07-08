package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import core.BrowserFirefox;
import discoverita.Discoverita;
import discoverita.NotSelectedCourse;
import discoverita.SuccessfullSubmission;
import discoverita.UnSuccessfullSubmission;
import discoverita.WrongEmail;

public class Tests {
	
	@Before
	public void setUp() {
		BrowserFirefox.openBrowser();
	}
	@Test
	public void checkButtons() {
		Discoverita.open();
		Discoverita.checkBarButtons();
	}
	@Test
	public void submission() {
		SuccessfullSubmission.setup();
		SuccessfullSubmission.checkBlankJava();
		SuccessfullSubmission.checkBlankDataBase();
		SuccessfullSubmission.checkBlankWebDesign();
		NotSelectedCourse.noCourse();
	}
	@Test
	public void emptyBox() {
		UnSuccessfullSubmission.open();
		UnSuccessfullSubmission.emptyBox();
	}
	@Test
	public void wrongEmail () {
		WrongEmail.setup();
		WrongEmail.checkBlankJava();
		WrongEmail.checkBlankDataBase();
		WrongEmail.checkBlankWebDesign();
	}
	@After
	public void tearDown() {
		BrowserFirefox.driver.quit();
	}
}
