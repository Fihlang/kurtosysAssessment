package com.javatestclient.pages;

import com.javatestclient.base.TestBase;
import com.javatestclient.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void hoverMenuTitle(String menuTitle){
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//div[@class='kurtosys-menu-title']/span[text()='"+menuTitle+"']"));
        actions.moveToElement(menuOption).perform();
    }


    public void clickWhitePaper() throws InterruptedException {

        String xpathValue = "//*[@id=\"kurtosys-menu-item-59810\"]/div/div/div/div/section/div/div/div[2]/div/div/div[2]/div/ul/li[4]/a/span[2]";

        WebElement menueItem = driver.findElement(By.xpath(xpathValue));
        menueItem.click();
        Thread.sleep(5000);
    }

    public void clickUTCWhitePapers() throws InterruptedException {

        String xpathValue = "/html/body/div[2]/div/div/section[2]/div/div/div/div/div/div/div/div/article[4]/div/div[1]/p/a";

        WebElement menueItem = driver.findElement(By.xpath(xpathValue));
        menueItem.click();
        Thread.sleep(2000);
    }

    public void formValues(String firstName, String lastName,
                           String CompanyName, String IndustryName) throws InterruptedException {

        String xpathValue = "//form[@id=\"pardot-form\"]/div/input";

      List<WebElement> elementList = driver.findElements(By.xpath(xpathValue));
        elementList.get(0).sendKeys(firstName);
        elementList.get(1).sendKeys(lastName);
        elementList.get(3).sendKeys(CompanyName);
        elementList.get(4).sendKeys(IndustryName);
        Thread.sleep(1000);
    }

    public void clickSendMeACopy() throws InterruptedException {

        String xpathValue = "/html/body/form/p[2]/input";

        WebElement menueItem = driver.findElement(By.xpath(xpathValue));
        menueItem.click();
        Thread.sleep(2000);
    }

    public String fieldValue() throws InterruptedException {

        String xpathValue = "/html/body/form/div[3]/p";
        WebElement menueItem = driver.findElement(By.xpath(xpathValue));
       return menueItem.getText();
    }







   public HomePage(WebDriver driver){
       PageFactory.initElements(driver, this);

   }

   /*
   public CareerPage clickCAREERSlink(){
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,500)");
        System.out.println(getCareerLink().getText());
        this.getCareerLink().click();
        return new CareerPage(driver);
    }*/

}
