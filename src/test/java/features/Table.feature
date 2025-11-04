Feature: Table Page test

  @tag1
  Scenario: Delete Table Row
    Given User is on Landing Page
    When User Enter Username = "testuser" And Password = "Password@123"
    And Navigate HomePage to WebtablePage
    And User Deletes a Row
    