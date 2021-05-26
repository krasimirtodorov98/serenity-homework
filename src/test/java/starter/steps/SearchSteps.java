package starter.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import starter.webelements.HomePage;

import java.util.List;
import java.util.stream.Collectors;

import static starter.webelements.HomePage.*;

public class SearchSteps extends PageObject {

    HomePage homePage;

    @Step("Navigate to Google Home Page")
    public void navigateToHomePage() {
        homePage.open();
    }

    @Step("Accept pop up window")
    public void acceptTOS(){
        $(ACCEPT_TERMS_BUTTON).click();
    }

    @Step("Enter Search criteria")
    public void enterSearchCriteria(String searchCriteria){
        $(SEARCH_BAR).clear();
        $(SEARCH_BAR).typeAndEnter(searchCriteria);
    }

    @Step("Get Result list")
    public List<String> getResultList(){
        homePage.waitForRenderedElements(SEARCH_RESULT);
        return findAll(SEARCH_RESULT)
                .stream()
                .map(WebElementFacade::getTextContent)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
