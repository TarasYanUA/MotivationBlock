import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import taras.yanishevskyi.DriverProvider;
import taras.yanishevskyi.WorkPages.AdminPanel;
import taras.yanishevskyi.WorkPages.MotivationBlock;
import taras.yanishevskyi.WorkPages.ProductPage;
import java.io.IOException;

public class HorizontalAppearanceWithBackgroundTest extends TestRunner{

    @Test(description = "Проверяем общие настройки модуля - горизонтальный вид с цветом фона")
    public void horizontalBlockAppearance() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToGeneralSettings();
        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.clickTabSettings();
        motivationBlock.clickTabAppearance();
        motivationBlock.selectSettingTemplateVariant("horizontal_tabs");
        motivationBlock.selectSettingBlockStyle("fill");
        motivationBlock.clicksettingBlockColor();
        motivationBlock.chooseBlueColorForBlock();
        motivationBlock.clickSubmitColorForBlock();
        motivationBlock.clickSaveButtonForSettings();
        //Переходим на страницу товара
        adminPanel.hoverToProductPage();
        ProductPage productPage = adminPanel.navigateToProductPage();
        productPage.clickAndTypeToSearchField();
        productPage.chooseProductGoPro();
        productPage.clickGearWheelOfProduct();
        productPage.clickPreviewButton();   //Находимся на витрине на странице товара
        adminPanel.focusBrowserTab();
        //Проверяем, что блок горизонтальный
        String actualResult = String.valueOf(productPage.getHorizontalBlock());
        Assert.assertTrue(actualResult.contains("ab__horizontal_tabs"),"Block is not horizontal or missed on the product page.");
        Assert.assertTrue(DriverProvider.getDriver().findElements(By.cssSelector(".ab__mb_items.fill.colored")).size() >=1,
                "Motivation block doesn't have a style 'With background'");
        takeScreenShot("300 Horizontal block with background");
    }
}