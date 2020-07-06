import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class UserTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		String pagetitle=driver.getTitle();
		System.out.println("Page title is"+pagetitle);
		String expected_title="Protractor practice website - WebTables";
		//validating title
		if(pagetitle.equalsIgnoreCase(expected_title))
			System.out.println("Title Matched");
			else 
			System.out.println("Title didn't match");
		// validating users are not exist in table

		if(driver.getPageSource().contains("FName1"))
			System.out.println("user already exist uanble to create duplicate user");
		else
		{
			//Adding user1
			
			//driver.findElement(By.xpath("//button[text()=' Add User']")).click();
			
			driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']")).click();
			driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FName1");
			driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("LName1");
			driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("user1");
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("pass1");
			WebElement Radiobtn=driver.findElement(By.xpath("//label[text()='Company AAA']"));
			Radiobtn.click();
			Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='RoleId']")));
			dropdown.selectByVisibleText("Admin");
			driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("admin@mail.com");
			driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("082555");
			driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		}
		
		// validating users2 are not exist in table
		if(driver.getPageSource().contains("FName2"))
			System.out.println("user2 already exist uanble to create duplicate user");
		else
		
		{
		//Clearing the text in text fields
		
		driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']")).click();
		driver.findElement(By.xpath("//input[@name='FirstName']")).clear();
		driver.findElement(By.xpath("//input[@name='LastName']")).clear();
		driver.findElement(By.xpath("//input[@name='UserName']")).clear();
		driver.findElement(By.xpath("//input[@name='Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Email']")).clear();
		driver.findElement(By.xpath("//input[@name='Mobilephone']")).clear();
		
		//Adding user2

		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FName2");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("LName2");
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("user2");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("pass2");
		WebElement Radiobtn1=driver.findElement(By.xpath("//label[text()='Company BBB']"));
		Radiobtn1.click();
		Select dropdown1=new Select(driver.findElement(By.xpath("//select[@name='RoleId']")));
		dropdown1.selectByVisibleText("Customer");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("customer@mail.com");
		driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("083444");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		}
		//Ensure that your users are added to the list

		if(driver.findElement(By.xpath("//td[text()='user2']")).isDisplayed())
		System.out.println("User2 added successfully");
		else
			System.out.println("User2 not added");


		if(driver.findElement(By.xpath("//td[text()='user1']")).isDisplayed())
		System.out.println("User1 added successfully");
		else
			System.out.println("User1 not added");


		    }
		}


