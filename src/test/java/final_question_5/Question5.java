package final_question_5;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import tests.AbstractTestStayLoggedIn;

public class Question5 extends AbstractTestStayLoggedIn
{
    @Test
    public void testBasketItem()
    {    
    	clearBasket();	
        MainPage mainPage = new MainPage(browser);
        
        browser.waitAndClick(mainPage.detergentMenu);
        browser.waitAndClick(mainPage.washingCategory);
      
        CategoryPage categoryPage = new CategoryPage(browser);
        
        browser.waitAndClick(categoryPage.chooseOmo);
        
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
        
        prices.clear();
        products.clear();
        
        browser.waitAndClick(categoryPage.searchBar);
        browser.waitAndSendKeys(categoryPage.searchBox, "Persil Deterjan" + "\n");
        clearBasket();
        
        List<WebElement> products2 = browser.findElements(By.cssSelector(".price-tag .value"));
        for(WebElement product2: products2) {
    		String temp2 = product2.getText();
    		temp2 = temp2.substring(0, temp2.length()-3);
    		float price2 = Float.parseFloat(temp2.replace(',','.'));
    		prices.add(price2);
        }
    	target = prices.indexOf(Collections.max(prices))+1;
    	//2nd copy of loop to find expensive item
    	
        browser.waitAndClick(browser.findElement(By.cssSelector(".sub-category-product-list .list:nth-of-type(" + target + ") .product-card-button")));

        
        browser.waitAndClick(mainPage.shoppingBasketButton);
        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
        }
        
        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.campaignDismissButton);
        //dismiss popup
        browser.waitAndClick(basketPage.clothBag);
        browser.waitAndClick(basketPage.alternativeProduct);
        browser.waitAndClick(basketPage.personnelChoice);
        //choose bag + alternatives
        
        browser.waitAndClick(basketPage.purchaseNote);
        browser.waitAndSendKeys(basketPage.inputNote, "bu deterjandan yoksa daha ucuzundan verebilirsiniz");

        browser.waitAndClick(basketPage.approveBasket);
    }
}
