Feature: Title of your feature


Scenario: login and redirect to landing page
	Given having user name "Admin" and password "Password"
	When redirect to login page
	And provide user name and password
	And click on login page
	Then redirect to landing page
	And validate section title

Scenario: login and redirect to landing page
	Given having user name "Bhaumik" and password "password1"
	When redirect to login page
	And provide user name and password
	And click on login page
	Then redirect to landing page
	And validate section title