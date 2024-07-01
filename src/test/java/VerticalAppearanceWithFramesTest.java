import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import taras.constants.DriverProvider;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import java.io.IOException;

public class VerticalAppearanceWithFramesTest extends TestRunner{

    @Test(description = "Проверяем общие настройки модуля - вертикальный вид с обрамлением")
    public void verticalBlockAppearance() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateTo_MotivationBlockSettings();
        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.clickTabSettings();
        motivationBlock.clickTabAppearance();
        motivationBlock.selectSettingTemplateVariant("vertical_tabs");
        motivationBlock.selectSettingBlockStyle("framed");
        motivationBlock.clicksettingBlockColor();
        motivationBlock.chooseRedColorForBlock();
        motivationBlock.clickSubmitColorForBlock();
        motivationBlock.clickSaveButtonForSettings();
        //Переходим на страницу товара
        adminPanel.hoverToProductPage();
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.clickAndType_SearchFieldOfProduct();
        productPage.chooseAnyProduct();
        productPage.navigateToStorefront_ProductPage();
        productPage.clickPreviewButton();   //Находимся на витрине на странице товара
        adminPanel.focusBrowserTab();
        //Проверяем, что блок вертикальный
        String actualResult = String.valueOf(productPage.getVerticalBlock());
        Assert.assertTrue(actualResult.contains("ab__vertical_tabs"),"Block is not vertical or missed on the product page!");
        Assert.assertTrue(DriverProvider.getDriver().findElements(By.cssSelector(".ab__mb_items.framed.colored")).size() >=1,
                "Motivation block doesn't have a style 'With frames'");
        takeScreenShot("200 Vertical block with frames");
    }
}