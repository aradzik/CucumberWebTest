Feature: Sending a message on the Moodle Pollub

  Scenario: Verification of send message
    Given open the Chrome and go to Moodle
    When enter the Username and Password
    And  send a message to Magdalena saying Cucumber Test
    And log out
    And login to Magdalena account
    And checking messages from the first account
    And delete last message
    And log out and exit browser
    Then print time
