package taras.workPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;

@SuppressWarnings("ALL")
public class MotivationBlock extends AbstractPage {
    public MotivationBlock(){
        super();
    }

    @FindBy(css = ".btn.cm-submit.cm-addons-save-settings")
    public WebElement saveButtonForSettings;

    @FindBy(id = "ab__motivation_block_appearance")
    public WebElement tabAppearance;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_description_type')]")
    private WebElement dropboxValueForElements_description_type;
    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")
    public WebElement checkbox_UseAdditionalProductCategories;

    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    private WebElement gearWheelOfAddon;
    @FindBy(xpath = "(//ul[@class=\"dropdown-menu\"]//a[contains(@href, \"ab__motivation_block.manage\")])[2]")
    private WebElement sectionDataManagement;
    @FindBy(xpath = "//a[text()='Доставка']")
    private WebElement elementDelivery;
    @FindBy(xpath = "//a[text()='Варианты оплаты']")
    private WebElement elementPaymentMethods;
    @FindBy(xpath = "//a[text()='Наши преимущества']")
    private WebElement elementOurAdvantages;
    @FindBy(xpath = "//a[text()='Найдите похожие']")
    private WebElement elementFindSimilar;
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
    WebElement settingTemplateVariant;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_appearance_type_styles')]")
    WebElement settingBlockStyle;
    @FindBy(className = "sp-preview-inner")
    public WebElement settingBlockColor;
    @FindBy(xpath = "//span[@title='#ff0000']")
    public WebElement redColorForBlock;
    @FindBy(xpath = "//span[@title='#cfe2f3']")
    public WebElement blueColorForBlock;
    @FindBy(className = "sp-choose")
    public WebElement submitColorForBlock;
    @FindBy(id = "ab__mb_template_path")
    private WebElement elementPage_Template;
    @FindBy(xpath = "//div[contains(@class, 'title-tab')]//span[text()='Доставка']")
    private WebElement elementDeliveryOnStorefront;
    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    private WebElement abMenuDropdown;
    @FindBy(xpath = "//a[contains(@href, 'ab__motivation_block.manage')][@id='2']")
    private WebElement sectionDataManagementAtabMenu;
    @FindBy(id = "sw_select_4_wrap")
    private WebElement statusButton;
    @FindBy(xpath = "//a[contains(@class, 'status-link-a cm-ajax')]")
    private WebElement statusActive;

    public Select getDropboxValueForElements_description_type(){
        return new Select(dropboxValueForElements_description_type);
    }
    
    public String selectDropboxValueForElements_description_type(String value) {
        getDropboxValueForElements_description_type().selectByValue(value);
        return value;
    }
    
    public void clickGearWheelOfAddon(){
        gearWheelOfAddon.click();
    }
    
    public void navigateToSectionDataManagement(){
        sectionDataManagement.click();
    }
    
    public void clickItemOurAdvantages(){
        elementOurAdvantages.click();
    }
    
    public WebElement getSidebarAdditionalInfo(){
        return sidebarAdditionalInfo;
    }
    
    public void clickTabCategories(){
        tabCategories.click();
    }
    
    public void clickAddCategoriesButton(){
        addCategoriesButton.click();
    }
    
    public WebElement getCategoryMenClothingExists(){
        return categoryMenClothingExists;
    }
    
    public WebElement getCategoryPlayStation(){
        return categoryPlayStationExists;
    }

    public Select getSettingTemplateVariant(){
        return new Select(settingTemplateVariant);
    }
    public String selectSettingTemplateVariant(String value){
        getSettingTemplateVariant().selectByValue(value);
        return value;
    }

    public Select getSettingBlockStyle(){
        return new Select(settingBlockStyle);
    }
    public String selectSettingBlockStyle(String value){
        getSettingBlockStyle().selectByValue(value);
        return value;
    }

    public void chooseElementDelivery(){
        elementDelivery.click();
    }
    
    public void chooseElementPaymentMethods(){
        elementPaymentMethods.click();
    }
    
    public void chooseElementFindSimilar(){
        elementPaymentMethods.click();
    }
    
    public Select getElementPage_Template(){
        return new Select(elementPage_Template);
    }
    
    public String selectElementPage_Template(String value){
        getElementPage_Template().selectByValue(value);
        return value;
    }
    
    public WebElement getElementDeliveryOnStorefront(){
        return elementDeliveryOnStorefront;
    }
    
    public void clickElementDeliveryOnStorefront(){
        elementDeliveryOnStorefront.click();
    }
    
    public void clickABMenuDropdown(){
        abMenuDropdown.click();
    }
    
    public void chooseSectionDataManagementAtABMenu(){
        sectionDataManagementAtabMenu.click();
    }
    
    public void clickStatusButton(){
        statusButton.click();
    }
    
    public void clickStatusActive(){
        statusActive.click();
    }
}