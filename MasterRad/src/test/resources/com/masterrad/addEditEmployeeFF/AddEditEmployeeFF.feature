Feature: Add New Employee and Edit Employee data

Validate that only user with admin role is able to add new Employee.

Scenario Outline: Add new Employee
Given Admin User navigates to Add Employee page
When Admin User enters Username "<email>"
When Admin enters Password "<password>"
When Admin enters First Name "<firstName>"
When Admin enters Last Name "<lastName>"
When Admin enters Mobile "<mobile>"
When Admin enters Position "<position>"
When Admin selects gender "<gender>"
When Admin enters BirthDate "<birthDate>"
When Admin enters Address "<address>"
When Admin selects employee type "<employeeType>"
When Admin clicks CONFIRM button 
#Then Admin created new employee
Examples:
|email						|password		|firstName	|lastName		|mobile		|position		|gender	|birthDate	  |address				|employeeType	|
|test12@test12.com|test12			|Pera				|Peric			|123456789|QA					|Male		|01//04//1986 |Nikole Tesle 1 |Employee   	|
|test34@test34.com|test34     |Marko			|Maric      |968457789|TESTER			|Pera   |09//04//1982 |Laze Kostica 5 |Admin				|


Scenario: Validete that mandotary files must be pre field
Given Admin User navigates to Add Employee page
When Admin clicks CONFIRM button
Then Validation messages are displayed

Scenario: Validate that every user must have unique email address
Given Admin User navigates to Add Employee page
When Admin User enters Username "admin@admin.com"
When Admin clicks CONFIRM button
Then Validation message are displayed

Scenario: Edit mandatory field of the Employee
Given Admin User navigates to Edit Employee page
When Admin edits Mobile field "111-222-333"
When Admin enters Password "pass123"
When Admin clicks Save button


#Scenario: Delete Employe 
#Given Admin User navigates to Edit Employee page
#When Admin User clicks Delete button  
#When Admin User confirms that he wants to delete the Employee


  



 
 
 