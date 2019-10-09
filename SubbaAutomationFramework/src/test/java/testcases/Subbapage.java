package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.Login;
import pages.SubbapageCreate;

public class Subbapage extends BaseClass{
	
	SubbapageCreate loginss;
	
	@Test
	
	public void subbaMethod() {
		
		
		SubbapageCreate loginss=PageFactory.initElements(driver, SubbapageCreate.class);
		 
	}

}
