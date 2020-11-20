@tag
Feature: Selenide Cucumber Test
  I want to test Automated tester feature 

  @tag1
  
  Scenario Outline: To verify the page navigation on Automated tester
    Given I am on the home page of Automated Tester
    And I click on link "<Chapter>" chapter
    And I verify the text present on the opened page
    And I navigate back to the home page
	Examples:
	|Chapter|
	|Chapter1|
    
