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
  @FindBy(id = "DeliveryForm_recipientCity")
  private WebElement recipientCityElement;
  @FindBy(xpath = "//div/input[@value = 'Розрахувати вартість']")
  private WebElement calculateCostButton;
  @FindBy(xpath = "//div[@class='place-cost']/input")
  private WebElement announcedPriceElement;


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

  public void selectRecipientCity(String city) {
    By recipientCityLocator =
        By.xpath("//ul[@id='delivery_recipient_cities']//li/span[text()='" + city + "']");

    recipientCityElement.click();
    getDriver().findElement(recipientCityLocator).click();

  }

  public void clickOnCalculateCostButton() {
    calculateCostButton.click();
  }

  public String getFieldColor(String characteristicsOfPlaces) {
    By characteristicsOfPlacesLocator =
        By.xpath("//input[@name='DeliveryForm[optionsSeat][1][" + characteristicsOfPlaces + "]']");
    return getDriver().findElement(characteristicsOfPlacesLocator).getCssValue("border");
  }

  public String getCssValueOfFields(String characteristicsOfPlaces) {
    String newCharacteristicsOfPlaces = null;
    switch (characteristicsOfPlaces) {
      case "Оголошена вартість":
        newCharacteristicsOfPlaces = "cost";
        break;
      case "Вага":
        newCharacteristicsOfPlaces = "weight";
        break;
      case "Довжина":
        newCharacteristicsOfPlaces = "volumetricLength";
        break;
      case "Ширина":
        newCharacteristicsOfPlaces = "volumetricWidth";
        break;
      case "Висота":
        newCharacteristicsOfPlaces = "volumetricHeight";
        break;
    }
    return  getFieldColor(newCharacteristicsOfPlaces);
  }
}







