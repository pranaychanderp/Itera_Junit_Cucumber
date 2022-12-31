package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Screenshot {
	
//	WebDriver driver;
//	@After(order=1)
//	public void takeScreenshot(Scenario scenario) {
//		
//		TakesScreenshot ss =  (TakesScreenshot)driver;
//		byte[] src = ss.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(src, "image/png", "screenshot");
//	}
//	public String addScreenshot(WebDriver driver,String screenshotname ) throws IOException{
//
//	      TakesScreenshot ss =  (TakesScreenshot)driver;
//	      File source = ss.getScreenshotAs(OutputType.FILE);
//	      String dest1 = System.getProperty("user.dir")+"/Test_Screenshots/"+screenshotname+".png";
//	      File finaldest = new File(dest1);
//	      FileUtils.copyFile(source, finaldest);
//	      return dest1;
//	}

}
