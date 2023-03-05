package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

  @FindBy(xpath = "//a[@class='cost']")
  private WebElement deliveryCostMenuItem;
  @FindBy(xpath = "//div[@id='popup_info']//i[contains(@class,'close btn_x')]")
  private WebElement closePopUpButton;

  public MainPage() {
    PageFactory.initElements(getDriver(), this);
  }

  public void openMainPage() {
    getDriver().get("https://novaposhta.ua/");
    closePopUpButton.click();
  }

  public void clickOnTheDeliveryPriceMenuItem() {
    deliveryCostMenuItem.click();
  }
}
