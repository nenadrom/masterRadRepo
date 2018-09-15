Feature: Login to VSMSPRO web application

As a user you need to go to the login page and do the validations.

#Passed
Scenario: Validate email field
Given User must be on VSMSPRO login page
When User enters email "admin@admin.com"
Then User checks email is present
Then Close browser
 
 #passed 
Scenario Outline: Login with correct email and password
Given User must be on VSMSPRO login page
When User enters email "<email>"
When User enters password "<password>"
Then User clicks LOGIN button
Then Dashboard page is displayed
Then Close browser
Examples: 
|email                |password    |
|admin@admin.com      |admin       |
|employee@employee.com|employee    |

#passed
Scenario Outline: Login with inccorrct email and password
Given User must be on VSMSPRO login page
When User enters email "<email>"
When User enters password "<password>"
Then User clicks LOGIN button
Then Validation message is displayed 
Then User is not logged in Dashboard
Then Close browser
Examples:
|email                |password    |
|admin@admin.com      |admindasd   |
|employee@employee.com|1243        |
|admin								|dada				 |
|@!#$@#$@							|%$#!%			 |
| 										|dasdas			 |
|dadsada@dadsa.				|					   |


Scenario Outline: Login after logout
Given User must be on VSMSPRO login page
When User enters email "<email>"
When User enters password "<password>"
Then User clicks LOGIN button
Then Dashboard page is displayed
Then User Logout
Then User clicks LOGIN button
Then Close browser
Examples: 
|email                |password    |
|admin@admin.com      |admin       |

 