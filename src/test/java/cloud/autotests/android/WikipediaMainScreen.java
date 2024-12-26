package cloud.autotests.android;

import io.qameta.allure.Step;
import cloud.autotests.android.components.SearchInputField;

public class WikipediaMainScreen {
    @Step("Ввести запрос поиска")
    public WikipediaMainScreen searchQuery(String query) {

        new SearchInputField().clickSearchField().searchQuery(query);
        return this;
    }
}
