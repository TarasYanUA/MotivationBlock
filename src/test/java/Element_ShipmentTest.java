import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.constants.DriverProvider;
import taras.workPages.*;

import java.io.IOException;

public class Element_ShipmentTest extends TestRunner {

    @Test(description = "Проверяем ШАБЛОН элемента мотивации 'Доставка'")
    public void elementShipmentOnStorefront() throws IOException {
        //Настраиваем модуль "Карты и геолокация"
        AdminPanel adminPanel = new AdminPanel();
        MapsAndGeolocation mapsAndGeolocation = adminPanel.navigateTo_MapsAndGeolocation_Settings();
        mapsAndGeolocation.selectDropboxValue_Service("google");
        if(!DriverProvider.getDriver().findElement(By.xpath("//input[contains(@id, 'addon_option_geo_maps_show_shippings_on_product')]")).isSelected()){
            mapsAndGeolocation.checkbox_ShowShippingCost.click();
        }
        mapsAndGeolocation.tab_Google.click();
        mapsAndGeolocation.clickAndType_GoogleApiKey();
        adminPanel.saveButtonOnTopRight.click();

        //Настраиваем модуль "Блок мотивации -- Управление данными"
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlock_DataManagementPage();
        motivationBlock.elementDelivery.click();
        motivationBlock.selectElementPage_Template("addons/ab__motivation_block/blocks/components/item_templates/geo_maps.tpl");
        adminPanel.saveButtonOnTopRight.click();

        //Переходим на витрину
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.clickAndType_SearchFieldOfProduct("GoPro");
        productPage.chooseAnyProduct();
        Storefront storefront = productPage.navigateToStorefront_ProductPage();
        storefront.selectLanguage("ru");
        //Проверяем, что элемент "Доставка" присутствует на странице товара
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(storefront.elementDelivery.isDisplayed(),
                "Element 'Delivery' is not present on the product page");
        //Проверяем, что присутствует шаблон от модуля "Карты и геолокация" в элементе "Доставка"
        softAssert.assertTrue(storefront.template_ShippingMethod.isEnabled(),
                "Motivation element does not have a template 'Shipping method' on the product page!");
        storefront.scrollToMotivationBlock();
        storefront.elementDelivery.click();
        takeScreenShot("400 Delivery element with template 'Shipping information'");
        softAssert.assertAll();
        System.out.println("Element_ShipmentTest has passed successfully!");
    }
}