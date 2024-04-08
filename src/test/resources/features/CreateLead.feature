@SalesForce_Leads_Creation
Feature: Creating a Lead in Salesforce

  @CreatingLeads
  Scenario Outline: Create a New lead
    Given Logged into Salesforce and present in Home Page
    When Goto App Launcher and click on View All
    And Select Sales from App launcher
    And User is on Sales Dashboard and Click on Leads
    And Click on New,to create a New lead
    And Enter all mandatory fields "<FirstName>" "<LastName>","<Company>"
    Then Lead should be created with the given name successfully.

    Examples: 
      | FirstName | LastName | Company   |
      | Soumya    | Kyasa    | TCS       |
      | Shiva     | Kyasa    | Cognizant |
