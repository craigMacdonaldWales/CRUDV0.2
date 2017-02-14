package BDDtest;

import java.awt.Toolkit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs{

	public static WebDriver driver;
	public static String Name;
	public static String Introduced;
	public static String Discontinued;
	public static String Company;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//
	@Given("^I am on the CRUD web portal$")
	public void user_is_on_Home_Page() throws Throwable {
		//WebDriver driver;
		String osSystem = System.getProperty("os.name");
		
		System.out.println(osSystem);
		switch (osSystem){
			case "Mac OS X":	
				System.setProperty("webdriver.gecko.driver", "//geckodriver//geckodriver"); // need to document this
				break;
			default:
				System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe"); // need to document this
				break;
		}
		

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://computer-database.herokuapp.com/computers"); //goto the CRUD portal
	    
	    //Toolkit toolkit = Toolkit.getDefaultToolkit();
	    //Dimension screenResolution = new Dimension((int) 
	      //                  toolkit.getScreenSize().getWidth(), (int) 
	        //                toolkit.getScreenSize().getHeight());

	    //driver.manage().window().setSize(screenResolution);
	    //driver.manage().window().setPosition(new Point(0,0));
	    //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    //Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
	    //driver.manage().window().setSize(dim);
	    
	  //Store the current window handle
	    
	    
		}
	

	@Given("^I have clicked the add a new computer button$")
	public void i_have_clicked_the_add_a_new_computer_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#add")).click(); // click the add button
	    //throw new PendingException();
	}

	@Given("^I have entered computer details$")
	public void i_have_entered_computer_details(DataTable computerDetails) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		List<Map<String,String>> data = computerDetails.asMaps(String.class,String.class);
		
		int milliAppend = dataUtils.getTimeInt();
		String appendString = Integer.toString(milliAppend);
		
		Name = (data.get(0).get("Name") + appendString);
		System.out.println(Name);
		Introduced = data.get(0).get("Introduced");
		System.out.println(Introduced);
		Discontinued = data.get(0).get("Discontinued");
		System.out.println(Discontinued);
		Company = data.get(0).get("Company");
		System.out.println(Company);
		
		//Map<String, String> data : computerDetails.asMaps(String.class, String.class);
		
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.id("add")).click();
	    //driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(Name);
	    //driver.findElement(By.id("introduced")).clear();
	    driver.findElement(By.id("introduced")).sendKeys(Introduced);
	    //driver.findElement(By.id("discontinued")).clear();
	    driver.findElement(By.id("discontinued")).sendKeys(Discontinued);
	    //driver.findElement(By.id("company")).click();
	    driver.wait(1);
	    
	    //new Select(driver.findElement(By.id("company"))).selectByVisibleText(Company);
	    driver.findElement(By.id("company")).sendKeys(Company);
	    //WebElement dropDownListBox = driver.findElement(By.id("company")); 
	   // Select clickThis = new Select(dropDownListBox); clickThis.selectByValue("Apple Inc.");
		
	    //throw new PendingException();
	}

	@When("^I click create this computer$")
	public void i_click_create_this_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.findElement(By.cssSelector("input.btn.primary")).click();

	}

	@Then("^the computer details I have entered are displayed in the main listing correctly$")
	public void the_computer_details_I_have_entered_are_displayed_in_the_main_listing_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		// Warning: assertTextPresent may require manual changes
		String expectedConfBanner;
		expectedConfBanner = "Done! Computer " + Name + " has been created";
		String actualConfBanner = driver.findElement(By.cssSelector("div.alert-message.warning")).getText();
		//assertTextPresent(driver.findElement(By.cssSelector("BODY")).getText().matches(expectedConfBanner));

		// Warning: assertTextPresent may require manual changes
		assertEquals(expectedConfBanner, actualConfBanner);
		
		// I want to write a fancy method for interrogating the table, but I don't have time!
	
	}
	
	@When("^I click cancel$")
	public void i_click_cancel() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.findElement(By.linkText("Cancel")).click();	
	}
		
	@Then("^I am returned to the main screen$")
	public void i_am_returned_to_the_main_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		//assertTrue(isElementPresent(By.cssSelector("#main > h1")));

	
	}
	
	

}

