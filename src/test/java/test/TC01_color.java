package test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import page.homePage;


public class TC01_color extends BaseTest{
	
	@Test
	public void TC01(){
		homePage hp = new homePage(driver);
		System.out.println("Total incident Happened: " + hp.getColorCount());
	}
	
	@Test
	public void TC02() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.getIncidentDate();
	}
	
	@Ignore
	@Test
	public void TC03() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.restGetIncidentDate();
	}
	
}