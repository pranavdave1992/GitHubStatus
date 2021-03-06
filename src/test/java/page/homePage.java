package page;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.BaseTest;

public class homePage extends BaseTest{

	WebDriver homePageDriver;
	
	public homePage(WebDriver driver) {
		homePageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@fill != '#28a745' and contains(@class,'day')]")
	List<WebElement> colorStatus;
	
	@FindBy(xpath = ".//div[@class='date']")
	WebElement incidentDate;
	
	@FindBy(xpath = ".//span[@class='value-hrs']")
	WebElement incidentHour;		
	
	@FindBy(xpath = ".//span[@class='value-mins']")
	WebElement incidentMin;
	
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions hover = new Actions(driver);
	
	public void getIncidentDate() throws InterruptedException {
		int c=0;
		
		for (WebElement i : colorStatus) 
		{ 
			System.out.println(++c);	
			getDetails(i);
		}
	}
	
	public void getDetails(WebElement a) throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);", a);
		Action ai = hover.moveToElement(a).build();
		ai.perform();
		Thread.sleep(5000);
		
		System.out.println(incidentDate.getText() + " " +
							incidentHour.getText()  + " " +
							incidentMin.getText());
		
		driver.findElement(By.xpath(".//*[text()='Today']")).click();
		System.out.println("-----------------------------");
	}
	
	public int getColorCount() {
		return colorStatus.size();
	}
	
}
