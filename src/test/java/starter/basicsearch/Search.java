package starter.basicsearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.SearchSteps;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class Search {

    @Managed(driver = "chrome")
    WebDriver webDriver;

    @Steps
    SearchSteps searchSteps;

    @Before
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void closeDriver(){
        if(webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void basicSearch() {
        final String searchCriteria = "xiaomi";

        searchSteps.navigateToHomePage();

        searchSteps.acceptTOS();
        searchSteps.enterSearchCriteria(searchCriteria);

        assertThat(searchSteps.getResultList())
                .matches(results -> results.size() > 0, "Result list size should be greater than zero.")
                .allMatch(title -> title.contains(searchCriteria));
    }
}
