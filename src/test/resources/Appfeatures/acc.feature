Feature: Admin Page Feature

Background:
Given user has already logged in to application
|username|password|
|admin@yourstore.com|admin|


Scenario: Admin page title
Given user is on Admin page
When user gets the title of the page
Then page title should be "Dashboard / nopCommerce administration"


