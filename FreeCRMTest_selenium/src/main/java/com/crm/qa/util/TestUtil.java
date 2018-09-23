package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT =30;
	public static long IMPLICITLY_WAIT =30;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public void takeScreenshotAtEndofTest() throws IOException{
		
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentdir =System.getProperty("user.dir");
		
		FileUtils.copyFile(src, new File(currentdir + "/screenshots/" + System.currentTimeMillis()+ "png"));
	}

}
