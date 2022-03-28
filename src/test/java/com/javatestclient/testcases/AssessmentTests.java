package com.javatestclient.testcases;

import com.javatestclient.base.TestBase;
import com.javatestclient.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssessmentTests extends TestBase {
    HomePage homePage;

    public AssessmentTests()throws IOException{
        super();
    }

    @BeforeMethod
    public void setUp()throws IOException{
        initialize();
        homePage = new HomePage(driver);
    }

    @Test
    public void Given_EmailFieldIsEmpty_Then_ReturnFieldIsRequired() throws InterruptedException {
        homePage.hoverMenuTitle("Resources");
        homePage.clickWhitePaper();
       // homePage.widgetContainer("White papers").click();
        homePage.clickUTCWhitePapers();
        homePage.formValues("Test1", "t2","t3","t4" );
        homePage.clickSendMeACopy();
        Assert.assertEquals(homePage.fieldValue(), "This field is required.");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
