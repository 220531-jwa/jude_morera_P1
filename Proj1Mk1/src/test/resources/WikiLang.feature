# comments like this

Feature: Wikipedia Language Links work

	Scenario: The English Link works
	Given user is on wikipedia home page
	When the user clicks on English link
	Then the title of the web page should be Wikipedia, the free encyclopedia
	