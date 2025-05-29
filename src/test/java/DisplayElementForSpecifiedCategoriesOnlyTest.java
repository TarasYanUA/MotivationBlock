
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;

public class DisplayElementForSpecifiedCategoriesOnlyTest extends TestRunner {

    @Test(description = "Элементу 'Гарантия и возврат' добавляем категории и проверяем отображение этого элемента на стр товаров из этих категорий")
    public void checkCategoriesForMotivationElement() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        //Настраиваем настройки модуля
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_Settings();
        motivationBlock.tabAppearance.click();
        motivationBlock.selectSettingTemplateVariant("vertical_tabs");
        adminPanel.saveButtonOnTopRight.click();

        //Настраиваем модуль "Блок мотивации -- Управление данными"
        adminPanel.navigateTo_MotivationBlock_DataManagementPage();
        motivationBlock.element_WarrantyAndReturns.click();
        //Добавляем категории для мотив. элемента
        motivationBlock.addCategoriesToMotivationElement();

        //Переходим на витрину
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.searchProduct("X-Box 360");
        Storefront storefront = productPage.navigateToStorefront_ProductPage();
        storefront.selectLanguage("ru");

        SoftAssert softAssert = new SoftAssert();

        //Проверяем, что элемент "Гарантия и возврат" присутствует для нужной категорий
        softAssert.assertTrue(!storefront.element_WarrantyAndReturns.isEmpty(),
                "Motivation element 'Warranty and returns' does not exist for a specified category 'Game consoles -- Microsoft'!");

        storefront.scrollToMotivationBlock();
        takeScreenShot("600 'Warranty and returns' is present at the product of 'Game consoles' category");
        storefront.selectLanguage("ar");
        storefront.scrollToMotivationBlock();
        takeScreenShot("602 'Warranty and returns' is present at the product of 'Men cloth' category (RTL)");
        storefront.selectLanguage("ru");
        storefront.navigateTo_MenClothCategory();
        storefront.chooseFirstProduct.click();
        softAssert.assertTrue(!storefront.element_WarrantyAndReturns.isEmpty(),
                "Motivation element 'Warranty and returns' does not exist for a specified category 'Men cloth'!");
        storefront.scrollToMotivationBlock();
        takeScreenShot("605 'Warranty and returns' is present at the product of 'Men cloth' category");

        //Проверяем, что элемента "Гарантия и возврат" нет на странице левого товара
        storefront.scrollToTop();
        storefront.menu_Apparel.click();
        storefront.chooseFirstProduct.click();
        softAssert.assertTrue(storefront.element_WarrantyAndReturns.isEmpty(),
                "Motivation element 'Warranty and returns' is present for a wrong category 'Apparel'!");
        storefront.scrollToMotivationBlock();
        takeScreenShot("610 Three motivation elements on the category 'Apparel'");

        softAssert.assertAll();
        System.out.println("DisplayElementForSpecifiedCategoriesOnlyTest has passed successfully!");
    }
}