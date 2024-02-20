package com.servicenow.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class LearnShadow {

	
	@Test
	public void shadow() {
		
		ChromeDriver driver=new ChromeDriver();
		
		Shadow sh=new Shadow(driver);
	
		
	}
}
