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

import java.time.Duration;
import java.util.ArrayList;

public class MotivationElementOnCategoryPagesTest extends TestRunner{

    @Test
    public void motivationElementIsDisplayedOnCategoryPages(){
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.clickButtonAuthorization();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToGeneralSettings();

        MotivationBlock motivationBlock = new MotivationBlock();
        motivationBlock.clickTabSettings();
        motivationBlock.selectDropboxValueForElements_description_type("smarty");
        motivationBlock.clickCheckboxUseAdditionalProductCategories();
        motivationBlock.clickSaveButtonForSettings(); //Сохранили настройки
        motivationBlock.clickGearWheelOfAddon();
        motivationBlock.navigateToSectionDataManagement();
        motivationBlock.clickItemOurAdvantages();
        //Проверяем наличие боковой панели с доп. инфо на странице "Наши преимущества"
        String actualText = motivationBlock.getSidebarAdditionalInfo().getText();
        Assert.assertTrue(actualText.contains("Дополнительная информация для формирования контента"), "There is no sidebar on the page!");

        //Проверяем категории и подкатегории для мотив. элементов
        motivationBlock.clickTabCategories();
        motivationBlock.clickAddCategoriesButton();
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
        adminPanel.chooseCategoryMenClothing();
        adminPanel.chooseCategoryPlayStation();
        adminPanel.clickSavePopup();
        adminPanel.clickSaveButtonOnTopRight();
        //Проверяем, что обе категории добавились в таблицу
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
        Assert.assertTrue(motivationBlock.getCategoryMenClothingExists().isDisplayed());
        Assert.assertTrue(motivationBlock.getCategoryPlayStation().isDisplayed());
        adminPanel.navigateToProductPage(adminPanel);
        ProductPage productPage = new ProductPage();
        productPage.clickAndTypeToSearchField();
        productPage.chooseProductGoPro();
        productPage.clickAtListOfCategories();
        (new WebDriverWait((productPage.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
        adminPanel.chooseCategoryMenClothing();
        adminPanel.chooseCategoryPlayStation();
        adminPanel.clickSavePopup();
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
        adminPanel.clickSaveButtonOnTopRight();
        productPage.clickGearWheelOfProduct();
        productPage.clickPreviewButton();   //Находимся на витрине на странице товара
        adminPanel.focusBrowserTab();
        //Скроллим до блока мотивации
        scrollToMotivationBlock(productPage);
        //Проверяем, что блок мотивации отображается у главной категории
        Assert.assertTrue(productPage.hoverMotivationBlockOnProductPage().isDisplayed());
        //Проверяем, что секция "Наши преимущества" отображается в дочерней категории
        productPage.navigateToApparelCategoryOnStorefront();
        productPage.chooseProductGoProOnStorefront();
        scrollToMotivationBlock(productPage);
        Assert.assertTrue(productPage.getElementOnProductPage_OurAdvantages().isDisplayed());

    }

    private static WebElement scrollToMotivationBlock(ProductPage productPage) {
        WebElement elementOfMotivationBlock = productPage.hoverMotivationBlockOnProductPage();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.moveToElement(elementOfMotivationBlock);
        hoverMotivationBlock.perform();
        return elementOfMotivationBlock;
    }
}
