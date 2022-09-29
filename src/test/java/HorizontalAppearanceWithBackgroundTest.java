import org.testng.Assert;
import org.testng.annotations.Test;
import taras.yanishevskyi.WorkPages.AdminPanel;
import taras.yanishevskyi.WorkPages.MotivationBlock;
import taras.yanishevskyi.WorkPages.ProductPage;

public class HorizontalAppearanceWithBackgroundTest extends TestRunner{

    @Test
    public void motivationBlockAppearance() {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.clickButtonAuthorization();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToGeneralSettings();

        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.clickTabSettings();
        motivationBlock.clickTabAppearance();
        motivationBlock.selectSettingTemplateVariant("horizontal_tabs");
        motivationBlock.selectSettingBlockStyle("framed");
        motivationBlock.clicksettingBlockColor();
        motivationBlock.chooseRedColorForBlock();
        motivationBlock.clickSubmitColorForBlock();
        motivationBlock.clickSaveButtonForSettings();
        //Переходим на страницу товара
        adminPanel.hoverToProductPage(adminPanel);
        adminPanel.navigateToProductPage();
        ProductPage productPage = new ProductPage();
        productPage.clickAndTypeToSearchField();
        productPage.chooseProductGoPro();
        productPage.clickGearWheelOfProduct();
        productPage.clickPreviewButton();   //Находимся на витрине на странице товара
        adminPanel.focusBrowserTab();
        //Проверяем, что блок горизонтальный
        String actualResult = String.valueOf(productPage.getHorizontalBlock());
        Assert.assertTrue(actualResult.contains("ab__horizontal_tabs"),"Block is not horizontal or missed on the product page.");
    }
}
