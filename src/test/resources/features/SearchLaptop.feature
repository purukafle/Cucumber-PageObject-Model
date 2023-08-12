Feature: Google search functionality
@SmokeTest
Scenario: Use google website to search a laptop
Given I open chrome browser
When I goto www.google.com website
And I enter Laptop
And I click Enter Button
Then I should see search results for laptop
Then I close chrome browser

