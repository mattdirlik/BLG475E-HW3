package tests.positive;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import tests.AbstractTestStayLoggedIn;

public class DiaperPurchaseWithoutSort extends AbstractTestStayLoggedIn
{
    @Test
    public void testBasketItem()
    {    
    	clearBasket();	
        MainPage mainPage = new MainPage(browser);
        
        browser.waitAndClick(mainPage.babyToysMenu);
        browser.waitAndClick(mainPage.diaperCategory);
      
        CategoryPage categoryPage = new CategoryPage(browser);
        
        browser.waitAndClick(categoryPage.choosePrima);
        browser.waitAndClick(categoryPage.choose4Beden);
        
        List<WebElement> products = browser.findElements(By.cssSelector(".price-tag .value"));
    	List<Float> prices = new ArrayList<Float>();
    	
    	for(WebElement product: products) {
    		String temp = product.getText();
    		temp = temp.substring(0, temp.length()-3);
    		float price = Float.parseFloat(temp.replace(',','.'));
    		prices.add(price);
    	}
    	Integer target = prices.indexOf(Collections.max(prices))+1;
    	//Save all prices into an array and find the index of the highest one
    	
        browser.waitAndClick(browser.findElement(By.cssSelector(".sub-category-product-list .list:nth-of-type(" + target + ") .product-card-button")));
        //Click on the most expensive one, unfortunately can't use the page object here as I needed to use the variable.
        
        
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
