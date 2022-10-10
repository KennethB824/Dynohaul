@regression
Feature: Vehicles page buttons

	Background:
		#@B26G16-89
		Given user is on login page
		When user enters credentials and clicks log in button
		Then user should be logged in and on base page
		
	@smoke
	@B26G16-90 @B26G16-87
	Scenario: SepReview - Export Grid dropdown is on the left of the page
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then "Export Grid dropdown" is on the "left" side of the page

	@smoke
	@B26G16-96 @B26G16-87
	Scenario: SepReview - Grid Settings button is on the right of the page
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then "Grid Settings button" is on the "right" side of the page

	@smoke
	@B26G16-88 @B26G16-87
	Scenario: SepReview - User should be able to click Export Grid dropdown
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then user is able to click Export Grid dropdown

	@B26G16-93 @B26G16-87
	Scenario: SepReview - User should be able to click Grid Settings button
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then user should be able to click Grid Settings button

	@smoke
	@B26G16-91 @B26G16-87
	Scenario: SepReview - User should be able to click refresh button
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then user should be able to click "refresh" button

	@B26G16-92 @B26G16-87
	Scenario: SepReview - User should be able to click reset button
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then user should be able to click "reset" button

	@smoke
	@B26G16-94 @B26G16-87
	Scenario: SepReview - Refresh button should be on the left side of Reset button
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then "Refresh" button should be on the "left" side of Reset button

	@smoke
	@B26G16-95 @B26G16-87 @wip
	Scenario: SepReview - Grid Settings should be on the right side of Reset button
		When user hovers over "Fleet" module and clicks on "Vehicles" page
		And user is on Vehicles page
		Then "Grid Settings" button should be on the "right" side of Reset button