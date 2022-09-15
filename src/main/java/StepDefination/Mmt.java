package StepDefination;

import TestBase.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.ArrayList;
//import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.MmtPage;

public class Mmt extends TestBase {

	public static MmtPage mmtpage = new MmtPage();

	@Given("^user is on the HomePage of the MMT site$")
	public void user_is_on_the_HomePage_of_the_MMT_site() throws Throwable {
		String url = "https://www.makemytrip.com/flights/";
		initialization(url);
		String ExpectedTitle = "Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip";
		String actualTitle = driver.getTitle();
		System.out.println("Home Page title ::" + actualTitle);
		// Verify the title
		Assert.assertEquals(actualTitle, ExpectedTitle);

	}

	@When("^user click on the \"([^\"]*)\" and enter \"([^\"]*)\" on flight page$")
	public void user_click_on_the_and_enter_on_flight_page(String fromto, String Destination) throws Throwable {
		Actions a = new Actions(driver);
		try {

			Thread.sleep(6000);
			WebElement fromm = driver.findElement(By.xpath(mmtpage.from));
			fromm.click();
			System.out.println("Destination From: " + Destination);
			fromm.sendKeys("Delhi");

			a.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(3000);
			a.sendKeys(Keys.ENTER).build().perform();

		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());

		}

	}

	@When("^user click on the \"([^\"]*)\" and enter \"([^\"]*)\" on  flight page$")
	public void from(String fromto, String Destination) throws Throwable {
		Actions a = new Actions(driver);
		try {

			WebElement too = driver.findElement(By.xpath(mmtpage.to));
			too.click();
			System.out.println("Destination Too: " + Destination);
			too.sendKeys(Destination);
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();

		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());

		}

	}

	@Then("^user click on Search$")
	public void user_click_on_Search() throws Throwable {
		try {
			WebElement search = driver.findElement(By.xpath(mmtpage.search));
			search.click();

		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());
		}

	}

	@When("^user click on Sort by \"([^\"]*)\"$")
	public void user_click_on_Sort_by(String depart) throws Throwable {
		try {
			if (depart == "Departure") {
				WebElement departurebutton = driver.findElement(By.xpath(mmtpage.departure));
				departurebutton.click();
			}
		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());
		}
	}

	@Then("^user print the airline Name$")
	public void user_print_the_airline_Name() throws Throwable {
		try {

		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());

		}
	}

	@Then("^print the second lowest Price$")
	public void print_the_second_lowest_Price() throws Throwable {
		try {

			List<WebElement> airlinePrice = driver.findElements(By.xpath(mmtpage.airlinePrice));
			List<WebElement> airlineNames = driver.findElements(By.xpath(mmtpage.airlineName));
			String eachPrice = "";
			String eachAirlineName = "";
			List<String> airlinePricesAsc = new ArrayList<String>();

			for (int i = 0; i < airlinePrice.size(); i++) {

				eachPrice = airlinePrice.get(i).getText();
				eachAirlineName = airlineNames.get(i).getText();

				eachPrice = eachPrice.substring(2);
				eachPrice = eachPrice.replace(",", "");
				airlinePricesAsc.add(eachPrice);
				Collections.sort(airlinePricesAsc);

			}
			System.out.println("airlinePricesAsc Looop: " + airlinePricesAsc);
			int p = Integer.parseInt(airlinePricesAsc.get(1));

			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

			String SecondLowest = formatter.format(p);
			SecondLowest = SecondLowest.replace(",", "");
			SecondLowest = SecondLowest.substring(2);

			SecondLowest = SecondLowest.substring(0, 4);

			for (int i = 0; i < airlinePrice.size(); i++) {
				String b = "";
				String c = airlinePrice.get(i).getText();
				c = c.substring(2);
				c = c.replace(",", "");
				System.out.println("C: " + c);
				if (c.contains(SecondLowest)) {
					System.out.println("2nd Lowest Price = " + c + " AirlineName  = " + airlineNames.get(i).getText());

					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Something Went wrong in the Method" + e.getMessage());

		}

	}

	@After
	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
		System.out.println("The Chrome Browser is Closed");
	}

}
