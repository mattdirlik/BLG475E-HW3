package tests.positive;

import org.junit.Assert;
import org.junit.Test;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import tests.AbstractTestStayLoggedIn;

public class FixedMeatTest extends AbstractTestStayLoggedIn
{
    @Test
    public void testBasketItem()
    {
        clearBasket();

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChickenMenu);

        browser.waitAndClick(mainPage.meatCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        //browser.waitAndClick(categoryPage.cookieDismissButton);
        browser.waitAndClick(categoryPage.addBasketMeat);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.campaignDismissButton);
        browser.waitAndClick(basketPage.purchaseNote);
        browser.waitAndSendKeys(basketPage.inputNote, "120 gramlık paketler şeklinde hazırlanmasını istiyorum");

        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket);

        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }
}
