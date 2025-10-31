
Feature: Login Page

  @tag
  Scenario Outline: Login with correct credentials
    Given User is on Landing Page
    When User Enter Username = <UserName> And Password = <Password>
    Then Homepage Is Displayed
    And Cards Are Displayed

    Examples: 
      | UserName | Password     |
      | testuser | Password@123 |
      | testuser | Password@123 |
      
  Scenario: Login with wrong credentials
    Given User is on Landing Page
    When User Enter Username = "testuser" And Password = "Password"
    Then Homepage Is Displayed
  
      
