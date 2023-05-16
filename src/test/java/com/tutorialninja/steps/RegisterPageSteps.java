package com.tutorialninja.steps;

import com.tutorialninja.pages.RegisterPage;
import com.tutorialninja.utility.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class RegisterPageSteps {
//    @When("^I click on my account link$")
//    public void iClickOnMyAccountLink() {
//    }
//
//    @And("^I select \"([^\"]*)\" option from my account options$")
//    public void iSelectOptionFromMyAccountOptions(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @Then("^I should navigate to register page successfully$")
    public void iShouldNavigateToRegisterPageSuccessfully() {
        Assert.assertEquals("Register page not displayed", "Register Account", new RegisterPage().getRegisterText());
    }

    @And("^I filled all mandatory field of registration$")
    public void iFilledAllMandatoryFieldOfRegistration() {
        new RegisterPage().enterFirstName("Iama");
        new RegisterPage().enterLastName("Patel");
        new RegisterPage().enterEmail("patel" + new Utility().getRandomString(4) + "@gmail.com");
        new RegisterPage().enterTelephone("01234567890");
        new RegisterPage().enterPassword("Hellonum1");
        new RegisterPage().enterConfirmPassword("Hellonum1");
        new RegisterPage().clickOnSubscribeRadioButton("Yes");
        new RegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("^I click on continue button of registration page$")
    public void iClickOnContinueButtonOfRegistrationPage() throws InterruptedException {
        Thread.sleep(2000);
        new RegisterPage().clickOnContinueButton();
    }

    @Then("^I should see account successfully created message$")
    public void iShouldSeeAccountSuccessfullyCreatedMessage() {
        Assert.assertEquals("Account not created successfully", "Your Account Has Been Created!", new RegisterPage().getAccountCreatedMessage());
    }

    @And("^I click on continue$")
    public void iClickOnContinue() {
        new RegisterPage().clickOnContinue();
    }

//    @Then("^I should logout successfully$")
//    public void iShouldLogoutSuccessfully() {
//    }
//
//    @And("^I click on continue button$")
//    public void iClickOnContinueButton() {
//    }
}
