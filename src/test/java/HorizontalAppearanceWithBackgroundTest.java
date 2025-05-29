import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;

public class HorizontalAppearanceWithBackgroundTest extends TestRunner{

    @Test(description = "Проверяем общие настройки модуля - горизонтальный вид с цветом фона")
    public void horizontalBlockAppearance() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        //Настраиваем настройки модуля
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_Settings();
        motivationBlock.tabAppearance.click();
        motivationBlock.selectSettingTemplateVariant("horizontal_tabs");
        motivationBlock.selectSettingBlockStyle("fill");
        Utils.setCheckboxState(motivationBlock.setting_ApplyContrastToElements, false);
        motivationBlock.selectColorForBlock(motivationBlock.blueColorForBlock);
        adminPanel.saveButtonOnTopRight.click();

        //Переходим на страницу товара
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.searchProduct("GoPro");
        Storefront storefront = productPage.navigateToStorefront_ProductPage();

        //Работаем с витриной
        SoftAssert softAssert = new SoftAssert();

        //Проверяем, что блок горизонтальный
        softAssert.assertTrue(!storefront.horizontalBlock.isEmpty(),"Block is not horizontal or missed on the product page.");

        //Проверяем, что мотив. элемент с фоном
        softAssert.assertTrue(!motivationBlock.elementIsFilled.isEmpty(),
                "Motivation block doesn't have a style 'With background'");
        takeScreenShot("300 Horizontal block with background");

        softAssert.assertAll();
        System.out.println("HorizontalAppearanceWithBackgroundTest has passed successfully!");
    }
}