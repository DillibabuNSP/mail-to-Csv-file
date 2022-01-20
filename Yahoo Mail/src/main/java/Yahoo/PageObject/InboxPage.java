package Yahoo.PageObject;

import com.opencsv.CSVWriter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Yahoo.Base.BaseClass.driver;

public class InboxPage {

    /*@FindBy(xpath="//a[@data-test-id='message-list-item']")
    List<WebElement>fromId;*/

    @FindBy(xpath = "//div[@data-test-id='senders']/span/child::span")
    List<WebElement>fromId;

    @FindBy(xpath = "//span[@data-test-id='message-subject']")
    List<WebElement>Subject;

    @FindBy(xpath="//time[@role='gridcell']/span")
    List<WebElement>receivedTime;

    public InboxPage(){
        PageFactory.initElements(driver,this);
    }

    public void getFromDetails(String outputFile) throws IOException {

        try{
            FileWriter data= new FileWriter(new File(outputFile));
            CSVWriter writer=new CSVWriter(data,',',CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
            List<String[]> Data=new ArrayList<String[]>();

     for(int id=0;id<fromId.size();id++){

         String fromID=fromId.get(id).getText();
         String subject=Subject.get(id).getText();
         String time=receivedTime.get(id).getText();
         String[] inboxData=fromID.split(" ");
         String[] subjectData=subject.split(" ");
         String[] timeData=time.split(" ");
         Data.add(inboxData);
         Data.add(subjectData);
         Data.add(timeData);
         }
     writer.writeAll(Data);
     writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}