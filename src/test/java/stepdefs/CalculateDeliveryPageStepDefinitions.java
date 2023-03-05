package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
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
    Thread.sleep(6000);
  }

  @When("I select Місто-отримувач as Київ")
  public void iSelectDeliveryCity() {
  }

  @When("I click on Розрахувати вартість button")
  public void iClickOnCalculateDeliveryButton() {
  }

  @Then("Input field Оголошена вартість highlighted in red")
  public void inputFieldOgoleshenaVartistHighlightedInRed() {
  }

}
