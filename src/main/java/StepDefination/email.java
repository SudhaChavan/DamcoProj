package StepDefination;

import TestBase.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.text.NumberFormat;
import java.util.ArrayList;
//import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.MmtPage;

public class email extends TestBase {

	public static MmtPage mmtpage = new MmtPage();
//	public static WebDriver driver;
//
//	@Given("^user is on the HomePage of the temp email site$")
//	public void user_is_on_the_HomePage_of_the_temp_email_site() throws Throwable {
//		String url = "https://temp-mail.org/en/";
//		initialization(url);
//		String ExpectedTitle = "Temp Mail - Disposable Temporary Email";
//		String actualTitle = driver.getTitle();
//		System.out.println("Home Page title ::" + actualTitle);
//		// Verify the title
//		Assert.assertEquals(actualTitle, ExpectedTitle);
//
//	}
//
//	WebElement copyEmailId = driver.findElement(By.xpath(mmtpage.copyButton));
//	String Emailsubject = "Sample Email Subject";
//	String messagecompose = "I am the Message to  the Temperory message";
//
//	@Given("^user Generate temporary email and copy the same using copy button\\.$")
//	public void user_Generate_temporary_email_and_copy_the_same_using_copy_button() throws Throwable {
//		WebElement EmailId = driver.findElement(By.xpath(mmtpage.emailId));
//		System.out.println("Email ID: " + EmailId.getText());
//
//		WebElement copyEmailId = driver.findElement(By.xpath(mmtpage.copyButton));
//		copyEmailId.click();
//
//		driver.get("https://mail.google.com/mail/u/0/#inbox");
//		WebElement composeEmail = driver.findElement(By.xpath(mmtpage.compose));
//		composeEmail.click();
//
//		// Create object of the Actions class
//		Actions actions = new Actions(driver);
//
//		actions.keyDown(Keys.CONTROL);
//		actions.sendKeys("v");
//		actions.keyUp(Keys.CONTROL);
//		actions.build().perform();
//
//		WebElement subject = driver.findElement(By.xpath(mmtpage.subject));
//		subject.click();
//		subject.sendKeys(Emailsubject);
//
//		WebElement compose = driver.findElement(By.xpath(mmtpage.compose));
//		compose.click();
//		compose.sendKeys(messagecompose);
//
//		WebElement sendButton = driver.findElement(By.xpath(mmtpage.sendButton));
//		sendButton.click();
//
//	}
//
//	@When("^Go to your Gmail and send an email on this temporary email\\.$")
//	public void go_to_your_Gmail_and_send_an_email_on_this_temporary_email() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
//	@When("^Go back to the site https://temp-mail\\.org/en/$")
//	public void go_back_to_the_site_https_temp_mail_org_en() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
//	@When("^Click to the newly received mail\\.$")
//	public void click_to_the_newly_received_mail() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
//	@Then("^Verify the Subject and Body of email$")
//	public void verify_the_Subject_and_Body_of_email() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
//	@Then("^Take a screenshot of the Email\\.$")
//	public void take_a_screenshot_of_the_Email() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
}
