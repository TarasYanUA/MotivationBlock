package taras.workPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;

import java.util.List;

public class CategoryPage extends AbstractPage {
    public CategoryPage() {super();}

    @FindBy(css = "span[id*='off_comp'][class='hand cm-combination-cat cm-uncheck hidden']")
    public List<WebElement> collapsedCategoryList;

    @FindBy(xpath = "//span[text()='Магазин: CS-Cart']/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement expandCategoryList;

    @FindBy(xpath = "//tr[contains(@id, 'cat_223')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_apparel;

    @FindBy(id = "input_cat_224")
    public WebElement categoryMenClothing;

    @FindBy(xpath = "//tr[contains(@id, 'cat_264')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_multimedia;

    @FindBy(xpath = "//tr[contains(@id, 'cat_245')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_videoGames;

    @FindBy(id = "input_cat_259")
    public WebElement categoryPlayStation;

    @FindBy(xpath = "//tr[contains(@id, 'cat_166')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_electronics;

    @FindBy(xpath = "//tr[contains(@id, 'cat_254')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_gameConsoles;

    @FindBy(xpath = "//tr[contains(@id, 'cat_263')]/..//span[contains(@class, 'icon-caret-right')]")
    public WebElement popup_category_consoles;

    @FindBy(id = "input_cat_255")
    public WebElement categoryConsolesMicrosoft;
}
