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
import java.io.IOException;
import java.time.Duration;

public class MotivationElementOnCategoryPagesTest extends TestRunner{
    @Test(description="Проверяем настройку модуля 'Учитывать дополнительные категории товара' и отображение элемента мотивации на дочерних категориях")
    public void motivationElementIsDisplayedOnCategoryPages() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToGeneralSettings();
        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.clickTabSettings();
        motivationBlock.selectDropboxValueForElements_description_type("smarty");
        if(! DriverProvider.getDriver().findElement(By.xpath("//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")).isSelected()){
            motivationBlock.clickCheckboxUseAdditionalProductCategories();
        }
        motivationBlock.clickSaveButtonForSettings();

        //Переходим на страницу редактирования товара
        adminPanel.hoverToProductPage();
        ProductPage productPage = adminPanel.navigateToProductPage();
        productPage.clickAndTypeToSearchField();
        productPage.chooseProductGoPro();
        if(DriverProvider.getDriver().findElements(By.cssSelector(".select2-selection__choice")).size() < 2) {
            productPage.clickAtListOfCategories();
            (new WebDriverWait((productPage.driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
            adminPanel.chooseCategoryMenClothing();
            adminPanel.chooseCategoryPlayStation();
            adminPanel.clickSavePopup();
            (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
        }
        adminPanel.clickSaveButtonOnTopRight();

        //Работаем с витриной
        productPage.clickGearWheelOfProduct();
        productPage.clickPreviewButton();
        adminPanel.focusBrowserTab();
        scrollToMotivationBlock(productPage);   //Скроллим до блока мотивации
        //Проверяем, что блок мотивации отображается у главной категории
        Assert.assertTrue(productPage.getMotivationBlockOnProductPage().isDisplayed(),
                "Motivation block is present on the product page!");
        takeScreenShot("100 Motivation block on product page of main category 'Camcorders'");
        //Проверяем, что блок мотивации отображается в дочерней категории
        scrollToMenuMenApparel(productPage);
        productPage.navigateToApparelCategoryOnStorefront();
        productPage.chooseProductGoProOnStorefront();
        scrollToMotivationBlock(productPage);
        Assert.assertTrue(productPage.getMotivationBlockOnProductPage().isDisplayed(), "Motivation block is absent on subcategory page!");
        takeScreenShot("110 Motivation block on product page of subcategory 'Men's clothing'");
    }

    private static void scrollToMotivationBlock (ProductPage productPage) {
        WebElement elementOfMotivationBlock = productPage.getMotivationBlockOnProductPage();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.moveToElement(elementOfMotivationBlock);
        hoverMotivationBlock.perform();
    }
    private static void scrollToMenuMenApparel (ProductPage productPage) {
        WebElement menuMenApparel = productPage.getMenuMenApparel();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.moveToElement(menuMenApparel);
        hoverMotivationBlock.perform();
    }
}