package android;

import io.qameta.allure.Step;
import android.components.SearchInputField;

public class WikipediaMainScreen {
    @Step("Ввести запрос поиска")
    public WikipediaMainScreen searchQuery(String query) {

        new SearchInputField().clickSearchField().searchQuery(query);
        return this;
    }
}
