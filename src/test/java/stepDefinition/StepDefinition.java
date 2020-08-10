package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    @Given("^user is on NetBanking landing page$")
    public void userIsOnNetBankingLandingPage()  {
        System.out.println("Navigate to login page");
    }

    @When("^user logs in into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsInIntoApplicationWithUsernameAndPassword(String username, String password) {
        System.out.println("Logged in successfully");
    }

    @Then("^Home page is populated$")
    public void homePageIsPopulated() {
        System.out.println("asdasdasdasd");

    }

    @And("^Cards are displayed$")
    public void cardsAreDisplayed() {

        System.out.println("asdasdasdasd");

    }

    @And("Cards are displayed {string}")
    public void cardsAreDisplayed(String arg0) {
    }


}
