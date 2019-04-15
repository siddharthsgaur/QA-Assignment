Feature: Login using username and password on flipkart And Adding product to cart


Scenario Outline: User should be able to Login and add a product to cart
Given I have flikart url
When I hit the flipkart url in browser
And I wait for the popup window
And I enter <username> and <password>
And I click login
Then I hover over men category
And Click sports shoes
And I scroll down to bottom
And Go to page two
And open the specific product
And Add it to cart


Examples:
|username  |password |
|9001068482|sidhon123|







