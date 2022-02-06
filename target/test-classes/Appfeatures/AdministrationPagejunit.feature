Feature: Admin Page Feature

Background:
Given user has already logged in to application
|username|password|
|admin@yourstore.com|admin|


Scenario: Admin page title
Given user is on Admin page
When user gets the title of the page
Then page title should be "Dashboard / nopCommerce administration"


Scenario: Customer section count
Given user is on Admin page
Then user gets Customers section and clicks on Customers dropdown
|Customers|
|Customer roles|
|Online customers|
|Vendors|
|Activity log|
|Activity Types|
|GDPR requests (log)|
And accounts section count should be 7