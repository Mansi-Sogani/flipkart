Feature: Flipkart App Test

	@Valid_Login
	Scenario: Valid Login Check
		Given Open Flipkart App
		Then Enter valid Login details
		Then Check whether user is logged in

	@Security_Check
	Scenario: Invalid Login using Facebook
		Given Open Flipkart App
		Then Enter Invalid Login details
		Then Check whether user is not logged in


	@Alert_Test
	Scenario Outline: Invalid Login Check
		Given Open Flipkart App
		Then Enter wrong Login details "<rownum>"
		Then Check whether error message displayed

		Examples:
			|rownum|
			|2|
			|3|


	@Functionality_Test1
	Scenario: Checking Search Box
	Given Open Flipkart App
	Then Search Iphone in Search Box
	Then Check Iphone Option


	@Functionality_Test2
	Scenario: Invalid Search Test
		Given Open Flipkart App
		Then Search Iphone with Invalid Search

	@Integration_Test
	Scenario: Checking Cart Validation
		Given Open Flipkart App
		Then Adding items to cart
		Then Check items in cart


	@UI_Test
	Scenario: Checking Navigation Bar
		Given Open Flipkart App
		Then Adding items using navigation bar
		Then Check whether navigation worked









