import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;

public class Elements_PaymentMethods_CategoryListTest extends TestRunner {

    @Test(description = "Проверяем ШАБЛОНЫ элементов мотивации 'Варианты оплаты' и 'Список категорий'")
    public void checkElements_PaymentMethods_CategoryListTest() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        //Настраиваем модуль "Блок мотивации -- Управление данными"
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_DataManagementPage();
        motivationBlock.elementPaymentMethods.click();
        motivationBlock.selectElementPage_Template("addons/ab__motivation_block/blocks/components/item_templates/payment_methods.tpl");
        adminPanel.saveButtonOnTopRight.click();
        //Включаем элемент "Найдите похожие" с шаблоном "Список категорий"
        motivationBlock.configureFindSimilarAsCategoryList();

        //Переходим на витрину
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.searchProduct("GoPro");
        Storefront storefront = productPage.navigateToStorefront_ProductPage();
        storefront.selectLanguage("ru");
        storefront.scrollToMotivationBlock();
        storefront.element_PaymentMethods.click();

        SoftAssert softAssert = new SoftAssert();

        //Проверяем, что у элемента присутствует шаблон "Способы оплаты"
        softAssert.assertTrue(storefront.template_PaymentMethods.isEnabled(),
                "Motivation element does not have a template 'Payment methods'!");
        takeScreenShot("500 Element 'Payment options' with template 'Payment methods'");
        storefront.element_FindSimilar.click();

        //Проверяем, что у элемента "Найдите похожие" присутствует шаблон "Список категорий" вместо обычного текста
        softAssert.assertTrue(storefront.template_CategoriesList.isEnabled(),
                "Motivation element does not have a template 'Categories list'!");
        takeScreenShot("510 Element 'Find similar' with template 'Categories list'");

        softAssert.assertAll();
        System.out.println("Elements_PaymentMethods_CategoryListTest has passed successfully!");
    }
}