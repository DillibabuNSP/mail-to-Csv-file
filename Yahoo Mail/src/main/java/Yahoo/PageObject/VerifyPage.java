package Yahoo.PageObject;

import Yahoo.ActionDriver.Action;

import static Yahoo.Base.BaseClass.driver;

public class VerifyPage {

    public static Boolean verifyPageTitle(String expectedTitle){

        String actual_Title = Action.getPageTitle();

        if (actual_Title.equals(expectedTitle)) {

            System.out.println("Expected title and actual title is equal");
            return true;
        }else {
            System.out.println("Expected title and actual title is not equal");
            return false;
        }
    }

}
