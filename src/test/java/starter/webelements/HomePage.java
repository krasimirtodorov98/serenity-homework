package starter.webelements;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.google.bg/")
public class HomePage extends PageObject {

    public static By ACCEPT_TERMS_BUTTON = By.cssSelector("button#L2AGLb > div[role='none']");
    public static By SEARCH_BAR = By.cssSelector(".a4bIc > input[role='combobox']");

    public static By SEARCH_RESULT = By.className("yuRUbf");
}
