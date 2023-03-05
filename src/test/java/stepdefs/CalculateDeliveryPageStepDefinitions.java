package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.example.pages.CalculateDeliveryPage;

public class CalculateDeliveryPageStepDefinitions {

  CalculateDeliveryPage calculateDeliveryPage = new CalculateDeliveryPage();

  @Then("I redirected to page with title Вартість доставки")
  public void iRedirectedToPageWithCorrectTitle() {
    String actualResult = calculateDeliveryPage.getPageTitle();
    Assertions.assertThat(actualResult)
        .as("Page title is not as expected")
        .isEqualTo("Вартість доставки");
  }

  @When("I select Місто-відправник as {string}")
  public void iSelectSentCity(String city) throws InterruptedException {
    calculateDeliveryPage.selectSenderCity(city);
    Thread.sleep(2000);
  }

  @When("I select Місто-отримувач as {string}")
  public void iSelectDeliveryCity(String city) throws InterruptedException {
    calculateDeliveryPage.selectRecipientCity(city);
    Thread.sleep(1000);
  }

  @When("I click on Розрахувати вартість button")
  public void iClickOnCalculateDeliveryButton() {
    calculateDeliveryPage.clickOnCalculateCostButton();
  }

  @Then("Input field {string} highlighted in red")
  public void inputFieldOgoleshenaVartistHighlightedInRed(String characteristicsOfPlaces) {
    SoftAssertions softly = new SoftAssertions();
    String actualResult = calculateDeliveryPage.getCssValueOfFields(characteristicsOfPlaces);

    softly.assertThat(actualResult).as("The field is not highlighted in red").contains(
        "rgb(243, 95, 857)");
    softly.assertAll();

  }

//  @And("Input field {string} highlighted in red")
//  public void inputFieldHighlightedInRed(String andCharacteristicsOfPlaces) {
//    inputFieldOgoleshenaVartistHighlightedInRed(andCharacteristicsOfPlaces);
//  }

}
