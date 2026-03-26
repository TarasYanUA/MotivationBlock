import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.workPages.AdminPanel;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;

public class MotivationElementOnCategoryPagesTest extends TestRunner {

    @Test(description = "Проверяем настройку модуля 'Учитывать дополнительные категории товара' и отображение элемента мотивации на дочерних категориях")
    public void motivationElementIsDisplayedOnCategoryPages() throws IOException {
        AdminPanel adminPanel = new AdminPanel();

        //Настраиваем настройки модуля
/*        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_Settings();
        motivationBlock.selectDropboxValueForElements_description_type("smarty");
        taras.workPages.Utils.setCheckboxState(motivationBlock.checkbox_UseAdditionalProductCategories, true);
        adminPanel.saveButtonOnTopRight.click();*/

        //Переходим на страницу редактирования товара
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.searchProduct("GoPro");
        productPage.addCategoriesToProduct();
        Storefront storefront = productPage.navigateToStorefront_ProductPage();

        //Работаем с витриной
        SoftAssert softAssert = new SoftAssert();
        storefront.scrollToMotivationBlock();

        //Проверяем, что блок мотивации отображается у главной категории
        softAssert.assertTrue(storefront.motivationBlock.isDisplayed(),
                "Motivation block is absent on the product page of the main category!");

        takeScreenShot("100 Motivation block on product page of main category 'Camcorders'");
        storefront.selectLanguage("ar");
        storefront.scrollToMotivationBlock();
        takeScreenShot("102 Motivation block on product page of main category 'Camcorders' (RTL)");

        //Проверяем, что блок мотивации отображается в дочерней категории
        storefront.navigateTo_MenClothCategory();
        storefront.productGoProOnStorefront.click();
        storefront.scrollToMotivationBlock();
        softAssert.assertTrue(storefront.motivationBlock.isDisplayed(),
                "Motivation block is absent on subcategory 'MenCloth' page!");
        takeScreenShot("110 Motivation block on product page of subcategory 'Men's clothing'");

        softAssert.assertAll();
        System.out.println("MotivationElementOnCategoryPagesTest has passed successfully!");
    }
}