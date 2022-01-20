import Yahoo.ActionDriver.Action;
import Yahoo.Base.BaseClass;
import Yahoo.PageObject.InboxPage;
import Yahoo.PageObject.PasswordPage;
import Yahoo.PageObject.SignInPage;
import Yahoo.PageObject.VerifyPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.io.IOException;


public class YahooPageTestScript extends BaseClass {

    SignInPage signInPage;
    PasswordPage passwordPage;
    InboxPage inboxPage;

    @BeforeMethod
    public void setup(){

        LaunchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void yahooInboxPage() throws IOException {

        signInPage =new SignInPage();
        passwordPage =new PasswordPage();
        inboxPage =new InboxPage();

        String Exp_Title= properties.getProperty("expectedTitle");

        if(VerifyPage.verifyPageTitle(Exp_Title)==true){
            signInPage.enterEmailId(properties.getProperty("username"));
            passwordPage.enterPassword(properties.getProperty("passWord"));
            inboxPage.getFromDetails(properties.getProperty("FilePath"));
        }else{
            System.out.println("Page Title is Wrong");
        }
    }
}
