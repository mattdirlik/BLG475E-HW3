package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class CategoryPage extends AbstractPage
{
    public CategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = ".sub-category-product-list .list:nth-of-type(18) .product-card-button")
    public WebElement addBasketMeat;
    //The position of the desired meat has changed so I modified this.
    
    @FindBy(xpath = ".//*[@class='brands-list-anchor']/div[@class='checks-label']/span[text()='Prima']")
    public WebElement choosePrima;
    //Finds the Prima brand.
    
    @FindBy(xpath = ".//*[@class='brands-list-anchor']/div[@class='checks-label']/span[text()='4 Beden']")
    public WebElement choose4Beden;
    
    @FindBy(linkText = "Önce En Yüksek Fiyat")
    public WebElement sortDescendingPrice;
    
    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-button")
    public WebElement addBasketDiaper;
    
    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-title")
    public WebElement goToDiaperPage;
}
