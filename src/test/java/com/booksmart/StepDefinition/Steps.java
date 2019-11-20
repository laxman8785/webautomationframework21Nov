package com.booksmart.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import com.booksmart.PageObjects.LoginPage;



@RunWith(Cucumber.class)
public class Steps {
	LoginPage login;
	String datafile="BVT/Input/BVT_GlobalSearch.xml";
    @Given("^I am on the booksmart login page$")
    public void i_am_on_the_booksmart_home_page() throws Throwable {        
        login=new LoginPage();
    }

    @When("^I click on \"([^\"]*)\" on the \"([^\"]*)\" Page$")
    public void i_click_on_something_on_the_somethingpage(String strArg1, String strArg2) throws Throwable {
    	 
    	login.setUsername("test@test.com");
    }

    @Then("^the \"([^\"]*)\" on the \"([^\"]*)\" Page should be visible$")
    public void the_somethingon_the_somethingpage_should_be_visible(String strArg1, String strArg2) throws Throwable {
    	System.out.println("Test2");
    	login.driverclose();
    }


    @Then("^I should be \"([^\"]*)\" to the booksmart landing \"([^\"]*)\" Page$")
    public void i_should_be_somethingto_the_booksmart_landing_somethingpage(String strArg1, String strArg2) throws Throwable {
    	System.out.println("Test3");
    	login.driverclose();
    }

    @And("^I enter \"([^\"]*)\" into the \"([^\"]*)\" Field on the \"([^\"]*)\" Page$")
    public void i_enter_something_into_the_somethingfeild_on_the_somethingpage(String strArg1, String strArg2, String strArg3) throws Throwable {
    	System.out.println("Test4");
    }
    
    @And("^I click on \"([^\"]*)\" on the \"([^\"]*)\" Field on the \"([^\"]*)\" Page$")
    public void i_click_on_something_on_the_somethingpage(String strArg1, String strArg2, String strArg3) throws Throwable {
    	System.out.println("Test4");
    }

}