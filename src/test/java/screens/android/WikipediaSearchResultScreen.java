package screens.android;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchResultScreen {
    private final ElementsCollection articlesListElements = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Открыть статью")
    public WikipediaSearchResultScreen openArticle(int numberOfArticle) {

        articlesListElements.get(numberOfArticle).click();
        return this;
    }

    @Step("Проверить, что результаты пойска получены")
    public void checkSearchResult() {
        articlesListElements.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

}
