package taras.workPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;


public class MotivationBlock extends AbstractPage {
    public MotivationBlock(){
        super();
    }


    @FindBy(id = "ab__motivation_block_appearance")
    public WebElement tabAppearance;

    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_description_type')]")
    WebElement dropboxValueForElements_description_type;

    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")
    public WebElement checkbox_UseAdditionalProductCategories;

    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    public WebElement gearWheelOfAddon;

    @FindBy(xpath = ".ab__am-menu a[href*='dispatch=ab__motivation_block.manage']")
    public WebElement sectionDataManagement;

    @FindBy(xpath = "//a[text()='Доставка']")
    public WebElement elementDelivery;

    @FindBy(xpath = "//a[text()='Варианты оплаты']")
    WebElement elementPaymentMethods;

    @FindBy(xpath = "//a[text()='Наши преимущества']")
    WebElement elementOurAdvantages;

    @FindBy(xpath = "//a[text()='Найдите похожие']")
    WebElement elementFindSimilar;

    @FindBy(css = ".sidebar-row.ab-mb-sidebar-row")
    WebElement sidebarAdditionalInfo;

    @FindBy(id = "categories")
    WebElement tabCategories;

    @FindBy(xpath = "//a[contains(@id, 'opener_picker_category_ids_')]")
    WebElement addCategoriesButton;

    @FindBy(xpath = "//tr[@id[substring(.,string-length(.) - string-length('_224') + 1) = '_224']]")
    WebElement categoryMenClothingExists;

    @FindBy(xpath = "//tr[@id[substring(.,string-length(.) - string-length('_259') + 1) = '_259']]")
    WebElement categoryPlayStationExists;

    @FindBy(id = "ab__mb_template_path")
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
    WebElement elementPage_Template;



    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    WebElement abMenuDropdown;

    @FindBy(xpath = "//a[contains(@href, 'ab__motivation_block.manage')][@id='2']")
    WebElement sectionDataManagementAtabMenu;

    @FindBy(id = "sw_select_4_wrap")
    WebElement statusButton;

    @FindBy(xpath = "//a[contains(@class, 'status-link-a cm-ajax')]")
    WebElement statusActive;


    private Select getDropboxValueForElements_description_type(){
        return new Select(dropboxValueForElements_description_type);
    }
    public void selectDropboxValueForElements_description_type(String value) {
        getDropboxValueForElements_description_type().selectByValue(value);
    }
    
    public WebElement getCategoryMenClothingExists(){
        return categoryMenClothingExists;
    }
    
    public WebElement getCategoryPlayStation(){
        return categoryPlayStationExists;
    }

    private Select getSettingTemplateVariant(){
        return new Select(settingTemplateVariant);
    }
    public void selectSettingTemplateVariant(String value){
        getSettingTemplateVariant().selectByValue(value);
    }

    private Select getSettingBlockStyle(){
        return new Select(settingBlockStyle);
    }
    public void selectSettingBlockStyle(String value){
        getSettingBlockStyle().selectByValue(value);
    }
    
    private Select getElementPage_Template(){
        return new Select(elementPage_Template);
    }
    public void selectElementPage_Template(String value){
        getElementPage_Template().selectByValue(value);
    }
}