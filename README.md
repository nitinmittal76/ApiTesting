# ApiTesting

## To Compile Code
`mvn clean install`

## To Run the Regression Test Cases
`mvn clean verify -Dtags=Regression`


## Test Data
API.csv 
Multiple row of test data can be added and executed
Location : /src/test/resources/Test data files/Regression/

## Report: index.html
Serenity Test Report will be created in folder C:\APIAutomationReports\Regression\Report_<currentDateTime>
Open Index.html, Click Test Results tab, Click Link under Scenario Api validation (6 examples)
To get details of step click Link Under Test Objective - Expand Steps - Click Green tab in Results Status Code and Weather API Response
