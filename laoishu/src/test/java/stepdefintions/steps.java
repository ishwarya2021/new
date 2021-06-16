package stepdefintions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class steps {

	public WebDriver driver;
	
	@Given("^User is launching uat url$")
	public void user_is_launching_uat_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\F816478\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    
		driver=new ChromeDriver();
		    		 
	driver.get("https://dvptmp-lablink.tpmg.kp.org/");
					
	}

	@When("^User clicking on login button$")
	public void user_clicking_on_login_button() throws Throwable {
		 driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[1]/div[1]/div[2]/div[1]/form/button[2]")).click();
		 
	}


	@And("^User entering valid credentials\"([^\"]*)\"and \"([^\"]*)\"$")
	public void user_entering_valid_credentials_and(String UserName, String Password) throws Throwable {

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(UserName);
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Password);
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Keys.RETURN);
	}

	@Then("^user logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
		System.out.println("Client Service User logged in Sucessfully");
		driver.findElement(By.xpath("//*[@id='loginLogout']")).click();
		driver.findElement(By.xpath("//*[@id='showloginDD']/li[2]/a")).click();
		System.out.println("My Dashboard page displayed");

		
		WebElement Addnewbutton=driver.findElement(By.className("mr-4" ));
		Addnewbutton.click();
		
		driver.findElement(By.id("caTitle")).sendKeys("demo alert");
		WebElement dropdown1=driver.findElement(By.id("Alertdept"));
		Select select=new Select(dropdown1);
		select.selectByIndex(3);
		driver.findElement(By.id("caCheckbox")).click();
		
		
		driver.findElement(By.id("caStartdate")).sendKeys("06/01/2021"+Keys.ENTER);
		driver.findElement(By.id("caEnddate")).sendKeys("06/02/2021"+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='CreateAlertDialog']/div/div/div[3]/div/div[5]/div[2]/div[2]")).sendKeys("test demo");
		
		
		driver.findElement(By.id("btnsubmitAlert")).click();
		
	        
	
	//	driver.findElement(By.className("alert-success-model")).click();
			
		//	driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div[1]/div[1]/div[1]/a/img")).click();
			//driver.findElement(By.className("align-middle ")).click();

	   //Boolean status=driver.findElement(By.xpath("//*[@class='bi bi-plus']")).isDisplayed();
	   
	 //Assert.assertTrue(status);
	}

	
}


