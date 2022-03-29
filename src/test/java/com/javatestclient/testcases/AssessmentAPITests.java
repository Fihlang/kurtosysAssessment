package com.javatestclient.testcases;

import com.javatestclient.base.TestBase;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AssessmentAPITests extends TestBase {

    @Test
    public void Given_UserAddsDetails_Then_SuccessResponse( ){

        RestAssured.baseURI = prop.getProperty("url");

        JSONObject jsonObj = new JSONObject()
                .put("First Name","John")
                .put("Last Name","Smith")
                .put("Company","Kytosis");

         given()
                .port(8080)
                .contentType("application/json")
                .body(jsonObj.toString())
                .when()
                .post("/testenvironment/text/send")
                 .then()
                .assertThat().statusCode(200)
                .assertThat().header("Server","Cloudflare");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
