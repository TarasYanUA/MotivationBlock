import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taras.constants.DriverProvider;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import taras.workPages.Storefront;

import java.io.IOException;
import java.time.Duration;

public class MotivationElementOnCategoryPagesTest extends TestRunner{
    @Test(description="Проверяем настройку модуля 'Учитывать дополнительные категории товара' и отображение элемента мотивации на дочерних категориях")
    public void motivationElementIsDisplayedOnCategoryPages() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        //Настраиваем настройки модуля
        MotivationBlock motivationBlock = adminPanel.navigateTo_MotivationBlockSettings();
        motivationBlock.selectDropboxValueForElements_description_type("smarty");
        if(!motivationBlock.checkbox_UseAdditionalProductCategories.isSelected()){
            motivationBlock.checkbox_UseAdditionalProductCategories.click();
        }
        motivationBlock.saveButtonForSettings.click();

        //Переходим на страницу редактирования товара
        ProductPage productPage = adminPanel.navigateToSection_Products();
        productPage.clickAndType_SearchFieldOfProduct("GoPro");
        productPage.chooseAnyProduct();
        if(DriverProvider.getDriver().findElements(By.cssSelector(".select2-selection__choice")).size() < 2) {
            productPage.pickerOfCategories.click();
            (new WebDriverWait((productPage.driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
            productPage.categoryMenClothing.click();
            productPage.categoryPlayStation.click();
            productPage.savePopup.click();
            (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
            adminPanel.saveButtonOnTopRight.click();
        }
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
        softAssert.assertTrue(storefront.motivationBlock.isDisplayed(), "Motivation block is absent on subcategory 'MenCloth' page!");
        takeScreenShot("110 Motivation block on product page of subcategory 'Men's clothing'");
        softAssert.assertAll();
        System.out.println("MotivationElementOnCategoryPagesTest has passed successfully!");
    }
}