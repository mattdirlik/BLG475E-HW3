package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class MainPage extends AbstractPage
{
    public MainPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;
    //added this to the main page as the cookie popup appears immediately upon entry to the site.
    //this is only needed when performing tests while logged out,
    //as I have accepted cookies on my Chrome profile I use to stay logged in
    
    @FindBy(id = "membership-login-link")
    public WebElement loginButton;

    @FindBy(linkText = "Et, Tavuk, Balık")
    public WebElement meatFishChickenMenu;
    
    @FindBy(linkText = "Bebek, Oyuncak")
    public WebElement babyToysMenu;
    
    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement diaperCategory;

    @FindBy(css = "a[data-monitor-ga-action='Kırmızı Et']")
    public WebElement meatCategory;

    @FindBy(css = ".shoping-cart-icon-block .fa-shopping-cart")
    public WebElement shoppingBasketButton;

    @FindBy(className = "progress-bar-text")
    public WebElement progressBarText;

    @FindBy(css = ".action-td .plus-orange")
    public WebElement plusButton;

    @FindBy(className = "rubbish")
    public WebElement trashButton;

    @FindBy(className = "go-to-basket-button")
    public WebElement goToBasketButton;
}
