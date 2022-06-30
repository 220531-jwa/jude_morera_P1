#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Employee Login
  
Background:
	Given a Employee is on LogigPage
	
	Scenario Outline: A Employee can Login using their uname and pword
	
	When the Employee types in their "<uname>" and "<pword>" and clicks the loginButton
	Then the Employee should be on the HomePage

    Examples: 
      | uname          | pword    |
      | Hello          | There    | 
      | UnlimitedPower | TheSenate| 
