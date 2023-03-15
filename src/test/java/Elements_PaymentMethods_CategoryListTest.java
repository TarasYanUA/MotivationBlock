import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import taras.yanishevskyi.DriverProvider;
import taras.yanishevskyi.WorkPages.AdminPanel;
import taras.yanishevskyi.WorkPages.MotivationBlock;
import taras.yanishevskyi.WorkPages.ProductPage;

import java.sql.Driver;
import java.time.Duration;

public class Elements_PaymentMethods_CategoryListTest extends TestRunner {
    @Test(description = "Проверяем ШАБЛОНЫ элемента мотивации 'Варианты оплаты' и 'Список категорий'")
    public void manageTwoMotivationElements(){
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToDataManagementPage();  //я на странице "Управление данными"
        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.chooseElementPaymentMethods();
        motivationBlock.selectElementPage_Template("addons/ab__motivation_block/blocks/components/item_templates/payment_methods.tpl");
        adminPanel.clickSaveButtonOnTopRight();
        //Включаем элемент "Найдите похожие" с шаблоном "Список категорий"
        motivationBlock.clickABMenuDropdown();
        motivationBlock.chooseSectionDataManagementAtABMenu();
        if(DriverProvider.getDriver().findElement(By.xpath("//a[@id=\"sw_select_4_wrap\"]")).getText().contains("Выкл.")){
            motivationBlock.clickStatusButton();
            motivationBlock.clickStatusActive();
        }
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cs-icon.icon-shopping-cart")));
        adminPanel.clickStorefrontMainButton();
        adminPanel.focusBrowserTab();
        ProductPage productPage = new ProductPage();
        productPage.chooseAnyProductOnStorefront();
        //scroll to block
        scrollToMotivationBlock(productPage);
        productPage.clickElementOnProductPage_PaymentMethods();
        //Проверяем, что у элемента присутствует шаблон "Способы оплаты"
        Assert.assertTrue(productPage.getPaymentMethodsAtElement().size() >=1,
                "Motivation element does not have a template 'Payment methods'!");
        productPage.clickElementOnProductPage_FindSimilar();
        //Проверяем, что у элемента "Найдите похожие" присутствует шаблон "Список категорий" вместо обычного текста
        Assert.assertTrue(productPage.getCategoryListAtElement().size() >=1,
                "Motivation element does not have a template 'Category list'!");
    }
    private static void scrollToMotivationBlock(ProductPage productPage) {
        WebElement elementOfMotivationBlock = productPage.getMotivationBlockOnProductPage();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.scrollToElement(elementOfMotivationBlock);
        hoverMotivationBlock.perform();
    }
}