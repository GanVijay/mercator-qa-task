package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    @FindBy(css = ".inventory_item")
    List<WebElement> items;

    WebElement selectedAddBtn;

    public InventoryPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String selectHighestPriceItem() {

        double highestPrice = 0.0;
        String itemName = "";

        for (WebElement item : items) {

            double price = Double.parseDouble(
                    item.findElement(By.cssSelector(".inventory_item_price"))
                            .getText().replace("$", "")
            );

            String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();

            if (price > highestPrice) {
                highestPrice = price;
                itemName = name;
                selectedAddBtn = item.findElement(By.cssSelector("button.btn_inventory"));
            }
        }

        return itemName;
    }

    public void addSelectedItemToCart() {
        selectedAddBtn.click();
    }
}
