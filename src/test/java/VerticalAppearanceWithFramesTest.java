import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.constants.DriverProvider;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;

public class VerticalAppearanceWithFramesTest extends TestRunner{

    @Test(description = "Проверяем общие настройки модуля - вертикальный вид с обрамлением")
    public void verticalBlockAppearance() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        //Настраиваем настройки модуля
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_Settings();
        motivationBlock.tabAppearance.click();
        motivationBlock.selectSettingTemplateVariant("vertical_tabs");
        motivationBlock.selectSettingBlockStyle("framed");
        motivationBlock.settingBlockColor.click();
        motivationBlock.redColorForBlock.click();
        motivationBlock.submitColorForBlock.click();
        adminPanel.saveButtonOnTopRight.click();

        //Переходим на страницу товара
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.clickAndType_SearchFieldOfProduct("GoPro");
        productPage.chooseAnyProduct();
        Storefront storefront = productPage.navigateToStorefront_ProductPage();

        //Работаем с витриной
        SoftAssert softAssert = new SoftAssert();
        //Проверяем, что блок вертикальный
        softAssert.assertTrue(!storefront.verticalBlock.isEmpty(),"Block is not vertical or missed on the product page!");
        softAssert.assertTrue(!DriverProvider.getDriver().findElements(By.cssSelector(".ab__mb_items.framed.colored")).isEmpty(),
                "Motivation block doesn't have a style 'With frames'");
        storefront.scrollToMotivationBlock();
        takeScreenShot("200 Vertical block with frames");
        softAssert.assertAll();
        System.out.println("VerticalAppearanceWithFramesTest has passed successfully!");
    }
}