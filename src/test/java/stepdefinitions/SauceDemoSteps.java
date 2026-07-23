package stepdefinitions;

import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import io.cucumber.java.en.*;

public class SauceDemoSteps {

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    String expectedItemName;


    @Given("user login to SauceDemo with username {string} and password {string}")
    public void userLoginToSauceDemoWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user add the highest priced item to the cart")
    public void userAddTheHighestPricedItemToTheCart() {
        expectedItemName = inventoryPage.selectHighestPriceItem();
        inventoryPage.addSelectedItemToCart();
    }

    @Then("user see correct item should be displayed in the cart")
    public void userSeeCorrectItemShouldBeDisplayedInTheCart() {
        cartPage.openCartAndVerify(expectedItemName);
    }
}
