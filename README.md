# BLG475E-HW3
Modified version of Murat Mercan's [project](https://github.com/muratme/migros) testing scenarios on Migros online market using Selenium. Due to personal circumstances I was unable to find a partner in time for this project so completed it alone.

## Log-in Issue Workaround
Since logging in requires SMS authentication, I made a workaround by adding an extra AbstractTest file, where the browser session is created using the user's existing Chrome profile. For this to work the user should log in to Migros online market and accept cookies before trying to run positive tests that require the user to be logged in. Any test relating to the basket requires this step to be completed.

## Modification to the Existing Scenario
I have modified the existing scenario in the project to work. It requires the user to log in and use their profile. The menu's and position of the desired product have changed so I modified their selectors, and also added the function to choose cloth bags at checkout as desired.

## Negative Test Cases
All tests that start with the basket being cleared will return negative results if the user is not logged in so I have only included 1 example.

The test in which the most expensive diaper is selected after sorting the results returns negative results if the browser resolution is too low, as the button to sort the results will not be visible thus will not be able to be clicked. If logged in and the user's profile preferences have Chrome set to a wider resolution, the test will return a positive result.
