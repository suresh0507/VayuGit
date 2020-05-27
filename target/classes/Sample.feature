Feature: Para Bank

  Scenario: Login to ParaBank
    Given Launch Browser and Get the Base URL
    When User Inputs the username and password
    And User clicks on Login button
    Then Able to Successfuly login
