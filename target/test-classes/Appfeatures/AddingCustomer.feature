Feature: Customer Page feature

Background:
Given user has already logged in to application
|username|password|
|admin@yourstore.com|admin|

Scenario Outline: Customer Added Successfully
And user is on Admin page
When user gets Customers section and clicks on Customers dropdown and clicks on Customers on the menu item
And user clicks on AddNew button
Then "Add a new customer" form is displayed
When user fills the form using excel sheet using "<SheetName>" and rownumber <RowNumber>
And clicks on Save button
Then "The new customer has been added successfully." message is displayed

Examples:
|SheetName|RowNumber|
|customerpage|0|
#|customerpage|1|
