Feature: The booksmart signon page should have verification on all the feilds

 Background: Launch Booksmart Signon page
      


  Scenario: Error message should become visible when I try to signon without Password
  	Given I am on the booksmart login page 
     When I click on "User Name" on the "Log On" Page
      And I enter "agent" into the "User Name" Field on the "Log On" Page
      And I click on "Signon" on the "Log On" Page
     Then the "Missing Credentials Error " on the "Log On" Page should be visible
  
  Scenario: Error message should become visible when i try to signon without User Name
    Given I am on the booksmart login page
     When I click on "Password" on the "Log On" Page
      And I enter "Password" into the "Password" Field on the "Log On" Page
      And I click on "Signon" on the "Log On" Page
     Then the "Missing Credentials Error " on the "Log On" Page should be visible
  
  Scenario: when I try to signon booksmart logon page with Valid credentials 
    Given I am on the booksmart login page
     When I click on "User Name" on the "Log On" Page
      And I enter "agent" into the "User Name" Field on the "Log On" Page
     Then I click on "Password" on the "Log On" Page
      And I enter "Password" into the "Password" Field on the "Log On" Page
      And I click on "Signon" on the "Log On" Page
     Then I should be "Log On" to the booksmart landing "Library" Page