package tests.positive;

import org.junit.Test;
import pages.common.CategoryPage;
import pages.common.MainPage;
import tests.AbstractTestStayLoggedIn;

public class DiaperNavigationWithSort_LoggedIn extends AbstractTestStayLoggedIn
{
    @Test
    public void testNavigation()
    {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToysMenu);

        browser.waitAndClick(mainPage.diaperCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        
        browser.waitAndClick(categoryPage.choosePrima);
        browser.waitAndClick(categoryPage.choose4Beden);
        browser.waitAndClick(categoryPage.sortDescendingPrice);
        browser.waitAndClick(categoryPage.goToDiaperPage);
        browser.waitForLoad();
    }
}
