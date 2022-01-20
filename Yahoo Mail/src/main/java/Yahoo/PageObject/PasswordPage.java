package Yahoo.PageObject;

import Yahoo.ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Yahoo.Base.BaseClass.driver;

public class PasswordPage {

    @FindBy(xpath="//*[@id='login-passwd']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login-signin']")
    WebElement nextBtn;

    public PasswordPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterPassword(String passWord){

        Action.enterTextValue(password,passWord);
        Action.click(driver,nextBtn);

    }
}