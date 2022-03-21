@smoke
Feature: Policyexpert home insurance

  Scenario Outline:
    Given I open the home insurance page
    And I enter the title "<title>"
    And I enter the first name "<firstName>"
    And I enter the last name "<lastName>"
    And I enter date of birth "<dateOfBirth>"
    And I enter marital status "<maritalStatus>"
    And I enter occupation "<occupation>"
    And I enter other occupation "<otherOccupation>"
    And I enter main phone number "<phoneNumber>"
    And I enter email address "<emailAddress>"
    And I enter financial questions "<financialQuestion>"
    And I enter address "<address>"
    And I corresponding address "<corresAddress>"
    And I enter property type "<propType>"
    And I enter type of house "<typeOfHouse>"
    And I enter property year "<propYear>"
    And I enter number of bedrooms "<numberOfBedrooms>"
    And I enter number of bathrooms "<numberOfBathrooms>"
    And I enter property main residence "<propertyMainResidence>"

    Examples:
      | title | firstName | lastName | dateOfBirth    | maritalStatus | occupation    | otherOccupation | phoneNumber | emailAddress            | financialQuestion | address                                             | corresAddress | propType |propYear|typeOfHouse|numberOfBedrooms|numberOfBathrooms|propertyMainResidence|
      | Mr    | Sam       | Brown     | 15-February-2000 | Married       | Software Consultant | No              | 07894561230 | vketipisz@qmetric.co.uk | No                | Policy Expert Ltd,110 Bishopsgate, London, EC2N 4AY | Yes           | House    |1900    |Detached house|4            |2       |Yes                           |

