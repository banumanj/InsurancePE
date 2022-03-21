package com.stepDefinitions;


import com.actions.Actions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class HomePageActions {

    Actions actions;
    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(HomePageActions.class);


    public HomePageActions() {
        this.driver = Hooks.driver;
        actions = new Actions(driver);
    }

    @FindBy(css = ".question-row-title .questionset-input .form-control")
    public WebElement titleSel;

    @FindBy(css = ".question-row-first-name .questionset-input .form-control")
    public WebElement firstNameTxt;

    @FindBy(css = ".question-row-last-name .questionset-input .form-control")
    public WebElement lastNameTxt;

    @FindBy(css = ".question-row-what-is-your-date-of .questionset-input .form-control")
    public List<WebElement> dateOfBirthSel;

    @FindBy(css = ".question-row-what-is-your-marital .questionset-input .form-control")
    public WebElement maritalStatusSel;

    @FindBy(css = ".question-row-what-is-your-occupat .questionset-input .form-control")
    public WebElement occupationTxt;

    @FindBy(css = ".question-row-what-is-your-occupat .questionset-input .list-group")
    public WebElement occupationLG;

    @FindBy(css = ".question-row-do-you-have-another .questionset-input .btn-group .btn")
    public List<WebElement> otherOccupationBtn;

    @FindBy(css = ".question-row-main-phone-number .questionset-input .form-control")
    public WebElement phoneNumberTxt;

    @FindBy(css = ".question-row-what-is-your-e-mail .questionset-input .form-control")
    public WebElement emailTxt;

    @FindBy(css = ".question-row-you-are-answering-th .questionset-input .btn-group .btn")
    public List<WebElement> financialIssuesBtn;

    @FindBy(css = ".question-row-address-of-the-prope .questionset-input .list-group")
    public WebElement addressLG;

    @FindBy(css = ".question-row-address-of-the-prope .questionset-input .form-control")
    public WebElement addressTxt;

    @FindBy(css = ".question-row-is-this-the-same-as .questionset-input .btn-group .btn")
    public List<WebElement> correspondenceBtn;

    @FindBy(css = ".question-row-what-type-of-propert .questionset-input .form-control")
    public WebElement propertyTypeTxt;

    @FindBy(css = ".question-row-which-of-these-best .form-control")
    public WebElement typeOfHouseSel;

    @FindBy(css = ".question-row-approximately-in-whi .questionset-input .form-control")
    public WebElement propertyYearTxt;

    @FindBy(css = ".question-row-how-many-bedrooms-do .questionset-input .form-control")
    public WebElement numberOfBedroomsSel;

    @FindBy(css = ".question-row-how-many-bathrooms .form-control")
    public WebElement numberOfBathroomsSel;

    @FindBy(xpath = "//div[@class='row question-row-is-the-property-your']//button[@type='button']")
    public List<WebElement> propertyMainResidenceBtn;



    @Before
    public void init() {
        PageFactory.initElements(driver, this);
    }


    @Given("I open the home insurance page")
    public void i_open_the_home_insurance_page() {
        actions.openDetailsPolicyExpertPage();
    }
    @And("I enter the title {string}")
    public void i_enter_the_title(String title) {
        actions.setSelectValue(titleSel, title);
    }

    @And("I enter the first name {string}")
    public void i_enter_the_first_name(String firstName) {
        actions.setTextBoxValue(firstNameTxt, firstName);
    }

    @And("I enter the last name {string}")
    public void i_enter_the_last_name(String lastName) {
        actions.setTextBoxValue(lastNameTxt, lastName);
    }

    @And("I enter date of birth {string}")
    public void i_enter_date_of_birth(String dateOfBirth) {
        String[] dBirth = dateOfBirth.split("-");
        int i = 0;
        for (WebElement dob : dateOfBirthSel) {
            actions.setSelectValue(dob, dBirth[i++]);
        }
    }

    @And("I enter marital status {string}")
    public void i_enter_marital_status(String maritalStatus) {
        actions.setSelectValue(maritalStatusSel, maritalStatus);
    }

    @And("I enter occupation {string}")
    public void i_enter_occupation(String occupation) throws InterruptedException{
        actions.setTextBoxValue(occupationTxt, occupation);
        try {
            occupationLG.sendKeys(Keys.ENTER);
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }


    @And("I enter other occupation {string}")
    public void i_enter_other_occupation(String otherOccupation) {
        Optional<WebElement> webElement = otherOccupationBtn.stream().filter(btn -> otherOccupation.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            actions.clickButton(webElement.get());
        }
    }

    @And("I enter main phone number {string}")
    public void i_enter_phone_number(String phoneNumber) {
        actions.setTextBoxValue(phoneNumberTxt, phoneNumber);
    }

    @And("I enter email address {string}")
    public void i_enter_email(String email) {
        actions.setTextBoxValue(emailTxt, email);
    }



    @And("I enter address {string}")
    public void i_enter_address(String address) throws InterruptedException {
        actions.setTextBoxValue(addressTxt, address);
        try{
            addressLG.sendKeys(Keys.ENTER) ;
        }catch (Exception ex) {

        }
    }

    @And("I corresponding address {string}")
    public void i_enter_corres_address(String corresAddress) {
        Optional<WebElement> webElement = correspondenceBtn.stream().filter(btn -> corresAddress.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            actions.clickButton(webElement.get());
        }
    }

    @And("I enter property type {string}")
    public void i_enter_prop_type(String propType) {
        actions.setTextBoxValue(propertyTypeTxt, propType);
        addressTxt.sendKeys(Keys.TAB);
        addressTxt.sendKeys(Keys.ENTER);
    }

    @And("I enter financial questions {string}")
    public void i_enter_financial_question(String financialQuestion) {
        Optional<WebElement> webElement = financialIssuesBtn.stream().filter(btn -> financialQuestion.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            actions.clickButton(webElement.get());
        }
    }

    @And("I enter type of house {string}")
    public void i_enter_type_of_house(String typeOfHouse) {
        actions.setSelectValue(typeOfHouseSel, typeOfHouse);
    }

    @And("I enter property year {string}")
    public void i_enter_property_year (String propYear) {
        actions.setTextBoxValue(propertyYearTxt, propYear);
    }

    @And("I enter number of bedrooms {string}")
    public void i_enter_number_Of_Bedrooms(String numberOfBedrooms){
        actions.setSelectValue(numberOfBedroomsSel,numberOfBedrooms) ;
    }

    @And("I enter number of bathrooms {string}")
    public void i_enter_number_Of_Bathrooms(String numberOfBathrooms){
        actions.setSelectValue(numberOfBathroomsSel,numberOfBathrooms) ;
    }

    @And("I enter property main residence {string}")
    public void i_enter_property_Main_Residence(String propertyMainResidence) {
        Optional<WebElement> webElement = propertyMainResidenceBtn.stream().filter(btn -> propertyMainResidence.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            actions.clickButton(webElement.get());
        }
    }

 }
