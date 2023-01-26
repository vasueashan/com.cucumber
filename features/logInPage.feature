@Regression
Feature: searchdata validation search        

  Scenario: login valid username and password
    And   Enter User name
    And   Enter pssword
    When Click on login button
    
    Scenario: login invalid username and password
    And   Enter User name
    And   Enter pssword
    When Click on login button
    When verify page title
  