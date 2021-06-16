Feature: To perform login in UAT
Scenario Outline: To Do Login validation
Given User is launching uat url
When User clicking on login button
And User entering valid credentials"<UserName>"and "<Password>"
Then user logged in successfully
Examples:
|UserName|Password|
|P854888 |Kaiser99|
|P854889 |Kaiser99|