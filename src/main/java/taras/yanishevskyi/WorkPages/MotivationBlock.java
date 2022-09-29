package taras.yanishevskyi.WorkPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import taras.yanishevskyi.AbstractPage;
import taras.yanishevskyi.DriverProvider;

public class MotivationBlock extends AbstractPage {
    public MotivationBlock(){
        super();
    }
    @FindBy(xpath = "//ul[@class=\"nav nav-tabs\"]//li[@id=\"settings\"]")
    private WebElement tabSettings;
    @FindBy(id = "ab__motivation_block_appearance")
    private WebElement tabAppearance;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_description_type')]")
    private WebElement dropboxValueForElements_description_type;
    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")
    private WebElement checkboxUseAdditionalProductCategories;
    @FindBy(css = ".btn.cm-submit.cm-addons-save-settings")
    private WebElement saveButtonForSettings;
    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    private WebElement gearWheelOfAddon;
    @FindBy(xpath = "(//ul[@class=\"dropdown-menu\"]//a[contains(@href, \"ab__motivation_block.manage\")])[2]")
    private WebElement sectionDataManagement;
    @FindBy(xpath = "//a[@href[substring(.,string-length(.) - string-length('motivation_item_id=1') + 1) = 'motivation_item_id=1']]")
    private WebElement itemOurAdvantages;
    @FindBy(xpath = "//td/a[contains(@href, 'motivation_item_id=3')]")
    private WebElement elementDelivery;
    @FindBy(xpath = "//td/a[contains(@href, 'motivation_item_id=2')]")
    private WebElement elementPaymentMethods;
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
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_template_variant')]")
    private WebElement settingTemplateVariant;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_appearance_type_styles')]")
    private WebElement settingBlockStyle;
    @FindBy(className = "sp-preview-inner")
    private WebElement settingBlockColor;
    @FindBy(xpath = "//span[@title='#ff0000']")
    private WebElement redColorForBlock;
    @FindBy(xpath = "//span[@title='#cfe2f3']")
    private WebElement blueColorForBlock;
    @FindBy(className = "sp-choose")
    private WebElement submitColorForBlock;
    @FindBy(id = "ab__mb_template_path")
    private WebElement elementPage_Template;
    @FindBy(xpath = "(//div[@class='ab__mb_item'])[3]")
    private WebElement elementDeliveryOnStorefront;
    @FindBy(css = ".cs-icon.dropdown-icon.ab__icon")
    private WebElement abMenuDropdown;
    @FindBy(xpath = "//a[contains(@href, 'ab__motivation_block.manage')][@id='2']")
    private WebElement sectionDataManagementAtabMenu;
    @FindBy(id = "sw_select_4_wrap")
    private WebElement statusButton;
    @FindBy(xpath = "//a[contains(@class, 'status-link-a cm-ajax')]")
    private WebElement statusActive;

    @Step
    public void clickTabSettings(){
        tabSettings.click();
    }
    @Step
    public void clickTabAppearance(){
        tabAppearance.click();
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

    public Select getSettingTemplateVariant(){
        return new Select(settingTemplateVariant);
    }
    @Step
    public String selectSettingTemplateVariant(String value){
        getSettingTemplateVariant().selectByValue(value);
        return value;
    }

    public Select getSettingBlockStyle(){
        return new Select(settingBlockStyle);
    }
    @Step
    public String selectSettingBlockStyle(String value){
        getSettingBlockStyle().selectByValue(value);
        return value;
    }
    @Step
    public void clicksettingBlockColor(){
        settingBlockColor.click();
    }
    @Step
    public void chooseRedColorForBlock(){
        redColorForBlock.click();
    }
    @Step
    public void chooseBlueColorForBlock(){
        blueColorForBlock.click();
    }
    @Step
    public void clickSubmitColorForBlock(){
        submitColorForBlock.click();
    }
    @Step
    public void chooseElementDelivery(){
        elementDelivery.click();
    }
    @Step
    public void chooseElementPaymentMethods(){
        elementPaymentMethods.click();
    }
    @Step
    public void chooseElementFindSimilar(){
        elementPaymentMethods.click();
    }
    @Step
    public Select getElementPage_Template(){
        return new Select(elementPage_Template);
    }
    @Step
    public String selectElementPage_Template(String value){
        getElementPage_Template().selectByValue(value);
        return value;
    }
    @Step
    public WebElement getElementDeliveryOnStorefront(){
        return elementDeliveryOnStorefront;
    }
    @Step
    public void clickElementDeliveryOnStorefront(){
        elementDeliveryOnStorefront.click();
    }
    @Step
    public void clickABMenuDropdown(){
        abMenuDropdown.click();
    }
    @Step
    public void chooseSectionDataManagementAtABMenu(){
        sectionDataManagementAtabMenu.click();
    }
    @Step
    public void clickStatusButton(){
        statusButton.click();
    }
    @Step
    public void clickStatusActive(){
        statusActive.click();
    }
}