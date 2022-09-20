package taras.yanishevskyi.WorkPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.yanishevskyi.AbstractPage;

public class MotivationBlock extends AbstractPage {
    public MotivationBlock(){
        super();
    }
    @FindBy(xpath = "//ul[@class=\"nav nav-tabs\"]//li[@id=\"settings\"]")
    private WebElement tabSettings;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_description_type')]")
    private WebElement dropboxValueForElements_description_type;
    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")
    private WebElement checkboxUseAdditionalProductCategories;
    @FindBy(css = ".btn.cm-submit.cm-addons-save-settings")
    private WebElement saveButtonForSettings;
    @FindBy(css = ".cs-icon.dropdown-icon.ab__icon")
    private WebElement gearWheelOfAddon;
    @FindBy(xpath = "(//ul[@class=\"dropdown-menu\"]//a[contains(@href, \"ab__motivation_block.manage\")])[2]")
    private WebElement sectionDataManagement;
    @FindBy(xpath = "//a[@href[substring(.,string-length(.) - string-length('motivation_item_id=1') + 1) = 'motivation_item_id=1']]")
    private WebElement itemOurAdvantages;
    @FindBy(css = ".sidebar-row.ab-mb-sidebar-row")
    private WebElement sidebarAdditionalInfo;
    @FindBy(id = "categories")
    private WebElement tabCategories;
    @FindBy(xpath = "//a[contains(@id, 'opener_picker_category_ids_')]")
    private WebElement addCategoriesButton;
    @FindBy(xpath = "//tr[@id[substring(.,string-length(.) - string-length('_224') + 1) = '_224']]")
    private WebElement categoryMenClothingExists;
    @FindBy(xpath = "//tr[@id[substring(.,string-length(.) - string-length('_259') + 1) = '_259']]")
    private WebElement categoryPlayStationExists;


    @Step
    public void clickTabSettings(){
        tabSettings.click();
    }

    @Step
    public Select getDropboxValueForElements_description_type(){
        return new Select(dropboxValueForElements_description_type);
    }
    @Step
    public String selectDropboxValueForElements_description_type(String value) {
        getDropboxValueForElements_description_type().selectByValue(value);
        return value;
    }
    @Step
    public void clickCheckboxUseAdditionalProductCategories(){
        checkboxUseAdditionalProductCategories.click();
    }
    @Step
    public void clickSaveButtonForSettings(){
        saveButtonForSettings.click();
    }
    @Step
    public void clickGearWheelOfAddon(){
        gearWheelOfAddon.click();
    }
    @Step
    public void navigateToSectionDataManagement(){
        sectionDataManagement.click();
    }
    @Step
    public void clickItemOurAdvantages(){
        itemOurAdvantages.click();
    }
    @Step
    public WebElement getSidebarAdditionalInfo(){
        return sidebarAdditionalInfo;
    }
    @Step
    public void clickTabCategories(){
        tabCategories.click();
    }
    @Step
    public void clickAddCategoriesButton(){
        addCategoriesButton.click();
    }
    @Step
    public WebElement getCategoryMenClothingExists(){
        return categoryMenClothingExists;
    }
    @Step
    public WebElement getCategoryPlayStation(){
        return categoryPlayStationExists;
    }
}
