Feature: Creation of a New Book 

  Scenario: when I create a new book and validate it got created
    Given I am on the booksmart home page
     When I click on "New Book" on the "Library" Page
     Then A "New Book " page should be displayed and validated
      And I enter "Test_Automation" into the "<field>" on the "New Book"Page
     Then I click on "Continue" and validate "New Book" is created