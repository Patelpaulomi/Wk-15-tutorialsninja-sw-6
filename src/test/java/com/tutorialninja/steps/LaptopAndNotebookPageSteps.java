package com.tutorialninja.steps;

import com.tutorialninja.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LaptopAndNotebookPageSteps {
    @And("^I click on show all laptop and notebook$")
    public void iClickOnShowAllLaptopAndNotebook() {
        new HomePage().clickOnShowAllLaptopAndNoteBook();
    }

//    @And("^I click on sort by position$")
//    public void iClickOnSortByPosition() {
//    }

//    @And("^I select product sort by \"([^\"]*)\"$")
//    public void iSelectProductSortBy(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @Then("^I should see product arrange in price high to low order successfully$")
    public void iShouldSeeProductArrangeInPriceHighToLowOrderSuccessfully() {
        Assert.assertEquals("Product not sorted by price High to Low", new LaptopAndNotebookPage().priceHighToLow(), new LaptopAndNotebookPage().getPriceHighToLow());
    }

//    @And("^I select currency \"([^\"]*)\"$")
//    public void iSelectCurrency(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @And("^I select product \"([^\"]*)\" from laptop and notebook page$")
    public void iSelectProductFromLaptopAndNotebookPage(String productName) {
        new LaptopAndNotebookPage().clickOnProductMacBook(productName);
    }

    @Then("^I should navigate to \"([^\"]*)\" product$")
    public void iShouldNavigateToProduct(String productName) {
        Assert.assertEquals("MacBook Product not display", productName, new ProductPage().getProductMacBookText());
    }

//    @And("^I click on add to cart button$")
//    public void iClickOnAddToCartButton() {
//    }

    @Then("^I should see product macbook added successfully message$")
    public void iShouldSeeProductMacbookAddedSuccessfullyMessage() throws InterruptedException {
        Assert.assertTrue("Product not added to cart", new ProductPage().getSuccessText().contains("Success: You have added MacBook to your shopping cart!"));
    }
//
//    @And("^I click on shopping cart button$")
//    public void iClickOnShoppingCartButton() {
//    }

//    @Then("^I should see shopping cart text$")
//    public void iShouldSeeShoppingCartText() {
//    }

    @And("^I should see \"([^\"]*)\" product$")
    public void iShouldSeeProduct(String productName) {
        Assert.assertEquals("Product name not matched", "MacBook", new ShoppingCartPage().getProductText());
    }

    @And("^I change quantity \"([^\"]*)\" for product$")
    public void iChangeQuantityForProduct(String quantity) {
        new ShoppingCartPage().changeQuantityForProduct(quantity);
    }

    @And("^I click on update quantity$")
    public void iClickOnUpdateQuantity() {
        new ShoppingCartPage().clickOnUpdateQuantity();
    }

    @Then("^I should see cart modified message$")
    public void iShouldSeeCartModifiedMessage() {
        Assert.assertTrue("Cart not modified", new ShoppingCartPage().getUpdateSuccessfullyText().contains("Success: You have modified your shopping cart!"));
    }

    @And("^I should see total price for macbook products$")
    public void iShouldSeeTotalPriceForMacbookProducts() {
        Assert.assertEquals("Total not matched", "£737.45", new ShoppingCartPage().getTotalPrice());
    }

    @And("^I click on checkout button$")
    public void iClickOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckoutButton();
    }

    @Then("^I should navigate to checkout page$")
    public void iShouldNavigateToCheckoutPage() {
        Assert.assertEquals("Not Navigate to checkout page", "Checkout", new CheckoutPage().getCheckoutText());
    }

    @And("^I should see new customer text$")
    public void iShouldSeeNewCustomerText() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("New Customer Text not found", "New Customer", new CheckoutPage().getNewCustomerText());

    }

    @And("^I click on guest checkout button$")
    public void iClickOnGuestCheckoutButton() throws InterruptedException {
        Thread.sleep(500);
        new CheckoutPage().clickOnGuestCheckOutRadioButton();
    }

    @And("^I click on continue button of guest checkout page$")
    public void iClickOnContinueButtonOfGuestCheckoutPage() {
        new CheckoutPage().clickOnContinueButton();
    }

    @And("^I filled all mandatory field of checkout page$")
    public void iFilledAllMandatoryFieldOfCheckoutPage() {
        new CheckoutPage().enterFirstName("Jack");
        new CheckoutPage().enterLastName("Smith");
        new CheckoutPage().enterEmailId("jack");
        new CheckoutPage().enterTelephone("01234567890");
        new CheckoutPage().enterAddressLine1("63 Harrow road");
        new CheckoutPage().enterCity("London");
        new CheckoutPage().enterPostCode("HA1 1AD");
        new CheckoutPage().selectCountry("United Kingdom");
        new CheckoutPage().selectRegion("Bristol");
    }

    @And("^I click on continue after fill all detail on checkout page$")
    public void iClickOnContinueAfterFillAllDetailOnCheckoutPage() {
        new CheckoutPage().clickOnContinue();
    }

    @And("^I add comments to text area about product order$")
    public void iAddCommentsToTextAreaAboutProductOrder() {
        new CheckoutPage().addCommentsToTextArea("Nothing to Say!");
    }

    @And("^I click checkbox of terms and condition$")
    public void iClickCheckboxOfTermsAndCondition() throws InterruptedException {
        Thread.sleep(2000);
        new CheckoutPage().checkTermsAndConditionCheckBox();
    }

    @And("^I click on continue of checkout$")
    public void iClickOnContinueOfCheckout() throws InterruptedException {
        Thread.sleep(2000);
        new CheckoutPage().clickContinue();
    }

    @Then("^I should see warning message regarding Payment method$")
    public void iShouldSeeWarningMessageRegardingPaymentMethod() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("Payment Warning Message not Displayed:", new CheckoutPage().getWarningMessage());
    }
}
