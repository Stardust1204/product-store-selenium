package example.ProductStore.Pages;

import example.ProductStore.MainUtility.Utility;
import example.ProductStore.PageValues.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductStore extends Utility {

    WebDriver driver;

    WebDriverWait wait;

    @FindBy(xpath = "//a[@id='signin2']")
    WebElement signUpBtn;
    @FindBy(xpath = "//input[@id='sign-username']")
    WebElement userNameInputText;
    @FindBy(xpath = "//input[@id='sign-password']")
    WebElement userPassInputText;
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpModalBtn;
    @FindBy(xpath = "//div[@class='modal fade show']//button[@class='close']")
    WebElement closeBtn;
    @FindBy(id = "login2")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='modal fade show']//h5[@id='logInModalLabel']")
    WebElement loginModalTitle;
    @FindBy(xpath = "//div[@class='modal fade show']//input[@id='loginusername']")
    WebElement loginUserName;
    @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement loginPassWord;
    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginModalButton;
    @FindBy(xpath = "//a[@class='hrefch'][text()='" + Constant.ITEM_CHOICE_ONE + "']")
    WebElement itemChoiceOneBtn;
    @FindBy(xpath = "//a[@class='hrefch'][text()='" + Constant.ITEM_CHOICE_TWO + "']")
    WebElement itemChoiceTwoBtn;
    @FindBy(xpath = "//a[@class='hrefch'][text()='" + Constant.ITEM_CHOICE_THREE + "']")
    WebElement itemChoiceThreeBtn;
    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement addToCartbtn;
    @FindBy(id = "nameofuser")
    WebElement nameOfUserTxt;
    @FindBy(xpath = "//div[@id='navbarExample']//a[@href='index.html']")
    WebElement homeTxt;
    @FindBy(xpath = "//a[text()='Cart']")
    WebElement cartBtn;
    @FindBy(xpath = "//div[@id='page-wrapper']//button[@class='btn btn-success']")
    WebElement placeOrderBtn;
    @FindBy(id = "orderModalLabel")
    WebElement placeOrderTxt;
    @FindBy(xpath = "//input[@id='name']")
    WebElement nameTxtBox;
    @FindBy(xpath = "//input[@id='country']")
    WebElement coutryTxtBox;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityTxtBox;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCardTxtBox;
    @FindBy(xpath = "//input[@id='month']")
    WebElement monthTxtBox;
    @FindBy(xpath = "//input[@id='year']")
    WebElement yearTxtBox;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;
    @FindBy(xpath = "//div[@class ='sweet-alert  showSweetAlert visible']//div[@class ='sa-button-container']//div[@class='sa-confirm-button-container']")
    WebElement validPurchaseBtn;


    public ProductStore(WebDriver driver, WebDriverWait wait) {
        //initialise wait and driver together
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public ProductStore signIn() {
        waitElement(signUpBtn, wait);
        signUpBtn.click();
        waitElement(userNameInputText, wait);
        writeText(userNameInputText, Constant.USER_NAME);
        writeText(userPassInputText, Constant.PASS_WORD);
        signUpModalBtn.click();

        //case of new user
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        try {
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
            }
        } catch (Exception e) {
            System.out.println("Element not visible");
            waitElement(loginBtn, wait);
        }

        return new ProductStore(this.driver, this.wait);
    }

    public ProductStore logIn() {
        waitElement(loginBtn, wait);
        loginBtn.click();
        waitElement(loginModalTitle, wait);
        writeText(loginUserName, Constant.USER_NAME);
        writeText(loginPassWord, Constant.PASS_WORD);
        loginModalButton.click();
        return new ProductStore(this.driver, this.wait);
    }

    public ProductStore addProductToCart() {
        waitElement(nameOfUserTxt, wait);
        //Add to cart item one
        itemChoiceOneBtn.click();
        waitElement(addToCartbtn, wait);
        addToCartbtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        waitElement(homeTxt, wait);
        homeTxt.click();

        // add to cart item 2
        waitElement(itemChoiceTwoBtn, wait);
        itemChoiceTwoBtn.click();
        waitElement(addToCartbtn, wait);
        addToCartbtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        waitElement(homeTxt, wait);
        homeTxt.click();

        //add to cart item 3
        waitElement(itemChoiceThreeBtn, wait);
        itemChoiceThreeBtn.click();
        waitElement(addToCartbtn, wait);
        addToCartbtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        waitElement(homeTxt, wait);
        homeTxt.click();
        return new ProductStore(this.driver, this.wait);
    }

    public ProductStore checkOut() {
        waitElement(homeTxt, wait);
        cartBtn.click();
        placeOrderBtn.click();
        waitElement(placeOrderTxt, wait);
        writeText(nameTxtBox, Constant.NAME);
        writeText(coutryTxtBox, Constant.COUNTRY);
        writeText(cityTxtBox, Constant.CITY);
        writeText(creditCardTxtBox, Constant.CREDIT_CARD_INFO);
        writeText(monthTxtBox, Constant.MONTH);
        writeText(yearTxtBox, Constant.YEAR);
        purchaseBtn.click();
        waitElement(validPurchaseBtn, wait);
        validPurchaseBtn.click();
        return new ProductStore(this.driver, this.wait);
    }
}
