
Feature: Slider Page

  @slidertest
  Scenario Outline: Slider Element is working properly
    Given User is on Landing Page
    When User Enter Username = "testuser" And Password = "Password@123"
    Then Homepage Is Displayed
    Then Navigate HomePage to SliderPage
   # Then Set Slider value to "50"