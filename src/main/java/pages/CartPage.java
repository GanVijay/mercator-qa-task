package pages;

import drivers.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WaitUtils.waitForVisible;


public class CartPage {

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    @FindBy(css = ".inventory_item_name")
    WebElement cartItemName;

    public CartPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void openCartAndVerify(String expectedItemName) {
        cartIcon.click();
        Assert.assertEquals(getCartItemName(), expectedItemName);
    }

    public String getCartItemName() {
        waitForVisible(cartItemName);
        return cartItemName.getText();
    }
}
