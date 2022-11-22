package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility
{
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Enter username in field
        sendTextToElement(By.name("username"),"Admin");

        // enter password field
        sendTextToElement(By.name("password"),"admin123");

        // click on login button
        clickOnElement(By.xpath("//button[@type='submit']"));

        String expectedMessage = "Dashboard";

        String actualTextMessage=getTextFromElement(By.xpath("//h6[contains(@class,'header-breadcrumb-module')]"));

        //Validate actual and expected message
        Assert.assertEquals("Dashboard", expectedMessage, actualTextMessage);
    }

}
