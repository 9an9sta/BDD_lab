package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculateDeliveryPage extends BasePage {

  @FindBy(xpath = "//h1[@class='page_title']")
  private WebElement pageTitleElement;
  @FindBy(id = "DeliveryForm_senderCity")
  private WebElement deliverySenderCityCheckBox;
  @FindBy(xpath = "//ul[@id='delivery_sender_cities']//li/span[text()='Вінниця']")
  private WebElement senderCityElement;

  public CalculateDeliveryPage() {
    PageFactory.initElements(getDriver(), this);
  }

  public String getPageTitle() {
    return pageTitleElement.getText();
  }

  public void selectSenderCity(String city) {

    By senderCityLocator =
        By.xpath("//ul[@id='delivery_sender_cities']//li/span[text()='" + city + "']");

    deliverySenderCityCheckBox.click();
    getDriver().findElement(senderCityLocator).click();
  }
}
