package Yahoo.PageObject;

import Yahoo.ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Yahoo.Base.BaseClass.driver;

public class SignInPage {

    @FindBy(xpath = "//*[@id='login-username']")
    WebElement userName;

    @FindBy(xpath = "//*[@for='persistent']")
    WebElement staySignIn;

    @FindBy(xpath = "//*[@id='login-signin']")
    WebElement emailNextBtn;

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }


    public void enterEmailId(String username){

        Action.enterTextValue(userName,username);
        Action.click(driver,staySignIn);
        Action.click(driver,emailNextBtn);

    }
}
