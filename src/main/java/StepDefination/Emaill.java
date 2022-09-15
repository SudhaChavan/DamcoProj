package StepDefination;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.MmtPage;
import TestBase.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Emaill extends TestBase {

	MmtPage mmtpage = new MmtPage();
	String Emailsubject = "Sample Email Subject";
	String messagecompose = "I am the Message to  the Temperory message";
	String tempEmailId = "";

	@Given("^user is on the HomePage of the temp email site$")
	public void user_is_on_the_HomePage_of_the_temp_email_site() throws Throwable {
		String url = "https://temp-mail.org/en/";
		initialization(url);
		String ExpectedTitle = "Temp Mail - Disposable Temporary Email";
		String actualTitle = driver.getTitle();
		System.out.println("Home Page title ::" + actualTitle);
	}

	@Given("^user Generate temporary email and copy the same using copy button\\.$")
	public void user_Generate_temporary_email_and_copy_the_same_using_copy_button() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(mmtpage.emailId)));

		WebElement EmailId = driver.findElement(By.xpath(mmtpage.emailId));
		String tempEmailId = EmailId.getText();

		System.out.println("Email ID: " + tempEmailId);

		WebElement copyEmailId = driver.findElement(By.xpath(mmtpage.copyButton));
		copyEmailId.click();

	}

	@When("^Go to your Gmail and send an email on this temporary email\\.$")
	public void go_to_your_Gmail_and_send_an_email_on_this_temporary_email() throws Throwable {
		String Emailsubject = "Sample Email Subject";
		String messagecompose = "I am the Message to  the Temperory message";
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		WebElement composeEmail = driver.findElement(By.xpath(mmtpage.compose));
		composeEmail.click();

		// Create object of the Actions class
		Actions actions = new Actions(driver);

		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		WebElement subject = driver.findElement(By.xpath(mmtpage.subject));
		subject.click();
		subject.sendKeys(Emailsubject);

		WebElement compose = driver.findElement(By.xpath(mmtpage.compose));
		compose.click();
		compose.sendKeys(messagecompose);

		WebElement sendButton = driver.findElement(By.xpath(mmtpage.sendButton));
		sendButton.click();

	}

	@When("^Go back to the site https://temp-mail\\.org/en/$")
	public void go_back_to_the_site_https_temp_mail_org_en() throws Throwable {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

		driver.switchTo().window(newTb.get(0));

	}

	@When("^Click to the newly received mail\\.$")
	public void click_to_the_newly_received_mail() throws Throwable {
		WebElement viewMail = driver.findElement(By.xpath(mmtpage.viewMail));
		viewMail.click();
	}

	@Then("^Verify the Subject and Body of email$")
	public void verify_the_Subject_and_Body_of_email() throws Throwable {
//		String Emailsubject = "Sample Email Subject";
//		String messagecompose = "I am the Message to  the Temperory message";

		WebElement tempSubject = driver.findElement(By.xpath(mmtpage.tempMailSubject));
		WebElement tempMailMessage = driver.findElement(By.xpath(mmtpage.tempMailMessge));
		WebElement tempMailId = driver.findElement(By.xpath(mmtpage.tempFromMailId));

		String emailSubText = tempSubject.getText();
		String messageText = tempMailMessage.getText();
		String mailId = tempMailMessage.getText();

		Assert.assertEquals(Emailsubject, emailSubText);
		Assert.assertEquals(messagecompose, messageText);

	}

	@Then("^Take a screenshot of the Email\\.$")
	public void take_a_screenshot_of_the_Email() throws Throwable {

		TakesScreenshot scr = (TakesScreenshot) driver;
		File file = scr.getScreenshotAs(OutputType.FILE);
		try {
			// save the screenshot taken in destination path
			FileUtils.copyFile(file, new File("./DamcoProj/src/main/resources/Screenshot/Test1_Email.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
