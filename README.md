# Policy Expert Test 
This framework is based on BDD

## Quick setup
- Java 8 
- Install IDE (e.g. Intelij Idea)
- Clone the repo
 
## Framework overview
Tech stack used:
- Java language (functional style)
- Maven, Junit,Selenium
- Gradle as build tool

## Project Overview 
- The project is designed by making use of Core java Concepts
- The HomePageActions Class helps us to identify the pageElements using pageFactoryFinder
- Actions has got  generic methods to assist the HomePageActions in performing various User operations

## How to run the tests
- To execute the test from command prompt 
- Navigate to the root of the project ./InsurancePE
- Use this Command: "gradle cucumber"

## Next steps

The next steps to improve the framework may include:
- Add more BDD tests (Gherkin language). Cucumber
- In the feature files, add addtion edge cases
- Add Jenkinsfile (or another CI file to manage CI/CD process)

Test Results :
![image](https://user-images.githubusercontent.com/61667828/159281703-c93d3f88-dc66-4e0f-a84b-c56a734768f5.png)
Report path : /build/reports/tests/test/index.html 
Report can be viewed by opening the .html file using one of the browsers
