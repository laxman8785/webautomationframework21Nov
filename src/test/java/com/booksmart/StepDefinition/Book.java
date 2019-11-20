package com.booksmart.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
public class Book {
	
	 	@Given("^I am on the booksmart home page$")
	    public void i_am_on_the_booksmart_home_page() throws Throwable {
		 System.out.println("Manoj1");
	    }
	    

	    @Then("^A \"([^\"]*)\" page should be displayed and validated$")
	    public void a_something_page_should_be_displayed_and_validated(String strArg1) throws Throwable {
	    	System.out.println("Manoj3");
	    }

	    @Then("^I click on \"([^\"]*)\" and validate \"([^\"]*)\" is created$")
	    public void i_click_on_something_and_validate_something_is_created(String strArg1, String strArg2) throws Throwable {
	    	System.out.println("Manoj4");
	    }

	    @And("^I enter \"([^\"]*)\" into the \"([^\"]*)\" field on the \"([^\"]*)\" Page$")
	    public void i_enter_something_into_the_somethingfield_on_the_somethingpage(String strArg1, String strArg2, String strArg3) throws Throwable {
	    	System.out.println("Manoj5");
	    }

	    @And("^I click on \"([^\"]*)\" on the\"([^\"]*)\" Page$")
	    public void i_click_on_somethingon_thesomethingpage(String strArg1, String strArg2) throws Throwable {
	    	System.out.println("Manoj8");
	    }

	    @And("^I enter \"([^\"]*)\" into the \"([^\"]*)\" on the \"([^\"]*)\"Page$")
	    public void i_enter_something_into_the_something_on_the_somethingpage(String field, String strArg1, String strArg2, String strArg3) throws Throwable {
	    	System.out.println("Manoj9");
	    }

}
