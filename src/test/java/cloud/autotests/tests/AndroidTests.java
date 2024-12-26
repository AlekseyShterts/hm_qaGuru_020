package cloud.autotests.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import cloud.autotests.android.WikipediaErrorScreen;
import cloud.autotests.android.WikipediaMainScreen;
import cloud.autotests.android.WikipediaSearchResultScreen;

@Tag("android")
@Owner("Shterts Aleksey")
@DisplayName("Check for Android")
public class AndroidTests extends TestBase {
    @Test
    @Feature("Positive case")
    @DisplayName("Check access search")
    void successfulSearchTest() {

        WikipediaMainScreen mainScreen = new WikipediaMainScreen();
        WikipediaSearchResultScreen searchResultScreen = new WikipediaSearchResultScreen();

        mainScreen.searchQuery("Appium");
        searchResultScreen.checkSearchResult();
    }

    @Test
    @Feature("Negative case")
    @DisplayName("Check error on open page")
    void unsuccessfulOpenArticleTest() {

        WikipediaMainScreen mainScreen = new WikipediaMainScreen();
        WikipediaSearchResultScreen searchResultScreen = new WikipediaSearchResultScreen();
        WikipediaErrorScreen errorScreen = new WikipediaErrorScreen();

        mainScreen.searchQuery("Appium");
        searchResultScreen.openArticle(0);
        errorScreen.checkError("An error occurred");
    }
}
