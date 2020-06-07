Feature: Change language on the Moodle Pollub

  Scenario: Change language to English
    Given open the Chrome and launch the application
    When change to English
    And check language
    And exit browser
    Then print during time
