import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.workPages.*;

import java.io.IOException;

public class Element_ShipmentTest extends TestRunner {

    @Test(description = "Проверяем ШАБЛОН элемента мотивации 'Доставка'")
    public void elementShipmentOnStorefront() throws IOException {
        AdminPanel adminPanel = new AdminPanel();

        //Настраиваем модуль "Карты и геолокация"
        MapsAndGeolocation mapsAndGeolocation = adminPanel.navigateTo_MapsAndGeolocation_Settings();
        mapsAndGeolocation.configureMapsAndGeolocation();
        adminPanel.saveButtonOnTopRight.click();

        //Настраиваем модуль "Блок мотивации -- Управление данными"
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_DataManagementPage();
        motivationBlock.elementShipment.click();
        motivationBlock.selectElementPage_Template("addons/ab__motivation_block/blocks/components/item_templates/geo_maps.tpl");
        adminPanel.saveButtonOnTopRight.click();

        //Переходим на витрину
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.searchProduct("GoPro");
        Storefront storefront = productPage.navigateToStorefront_ProductPage();
        storefront.selectLanguage("ru");

        SoftAssert softAssert = new SoftAssert();

        //Проверяем, что элемент "Доставка" присутствует на странице товара
        softAssert.assertTrue(!storefront.elements_Delivery.isEmpty(),
                "Element 'Delivery' is not present on the product page");

        //Проверяем, что присутствует шаблон от модуля "Карты и геолокация" в элементе "Доставка"
        softAssert.assertTrue(storefront.template_ShippingMethod.isEnabled(),
                "Motivation element does not have a template 'Shipping method' on the product page!");

        storefront.scrollToMotivationBlock();
        storefront.elements_Delivery.getFirst().click();
        takeScreenShot("400 Delivery element with template 'Shipping information'");
        
        softAssert.assertAll();
        System.out.println("Element_ShipmentTest has passed successfully!");
    }
}