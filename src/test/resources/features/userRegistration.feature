Feature: User registrations

  Scenario: Creating few user registrations
    Given User is on registration page
    When User gets list of users with specific details
    Then Enter all given details
      | Soumya | Kyasa | Testing     | 1234567 |
      | Shiva  | Kyasa | Development | 8901234 |
    Then Users should be created successfully
