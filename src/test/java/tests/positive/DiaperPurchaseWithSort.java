package tests.positive;

import org.junit.Assert;
import org.junit.Test;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import tests.AbstractTestStayLoggedIn;

public class DiaperPurchaseWithSort extends AbstractTestStayLoggedIn
{
    @Test
    public void testBasketItem()
    {
        //login(context.getInternalProps().getUsername(), context.getInternalProps().getPassword());
        clearBasket();

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToysMenu);

        browser.waitAndClick(mainPage.diaperCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        //browser.waitAndClick(categoryPage.cookieDismissButton);
        
        browser.waitAndClick(categoryPage.choosePrima);
        browser.waitAndClick(categoryPage.choose4Beden);
        browser.waitAndClick(categoryPage.sortDescendingPrice);
        browser.waitAndClick(categoryPage.addBasketDiaper);
        

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.campaignDismissButton);
        browser.waitAndClick(basketPage.clothBag);

        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket);

        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }
}
