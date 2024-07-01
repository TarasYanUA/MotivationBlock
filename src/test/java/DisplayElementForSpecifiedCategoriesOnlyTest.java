import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import taras.constants.DriverProvider;
import taras.workPages.AdminPanel;
import taras.workPages.MotivationBlock;
import taras.workPages.ProductPage;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DisplayElementForSpecifiedCategoriesOnlyTest extends TestRunner{
    @Test(description = "Элементу 'Наши преимущества' добавляем категории и проверяем отображение этого элемента на стр товаров из этих категорий")
    public void checkCategoriesForMotivationElement() throws IOException {
        AdminPanel adminPanel = new AdminPanel();
        MotivationBlock motivationBlock = new MotivationBlock();
        adminPanel.navigateToAddonsPage(adminPanel);
        adminPanel.clickButtonOfAddon();
        adminPanel.navigateToDataManagementPage();  //я на странице "Управление данными"
        motivationBlock.clickItemOurAdvantages();
        //Добавляем категории для мотив. элемента
        motivationBlock.clickTabCategories();
        if(DriverProvider.getDriver().findElement(By.xpath("//p[text()='Все категории включены']")).isDisplayed()){
        motivationBlock.clickAddCategoriesButton();
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
        adminPanel.chooseCategoryMenClothing();
        adminPanel.chooseCategoryPlayStation();
        adminPanel.clickSavePopup();
        adminPanel.clickSaveButtonOnTopRight();
        }
        //Проверяем, что обе категории находятся в таблице
        (new WebDriverWait((motivationBlock.driver), Duration.ofSeconds(4)))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
        Assert.assertTrue(motivationBlock.getCategoryMenClothingExists().isDisplayed());
        Assert.assertTrue(motivationBlock.getCategoryPlayStation().isDisplayed());
        //Переходим на витрину
        adminPanel.clickStorefrontMainButton();
        ArrayList tabs = new ArrayList<String> (DriverProvider.getDriver().getWindowHandles());
        for(int ii = 0; ii <= 1; ii++) {
            DriverProvider.getDriver().switchTo().window(tabs.get(ii).toString());
        }
        ProductPage productPage = new ProductPage();
        productPage.chooseProductOnHomepage();
        //Проверяем, что элемента "Наши примущества" нет на странице левого товара
        List<WebElement> listOfTabsOfBlock = productPage.getNumberOfTabsOfBlock();
        int expectedNumberOfTabs = 3;
        int actualNumberOfTabs = listOfTabsOfBlock.size();
        Assert.assertEquals(actualNumberOfTabs, expectedNumberOfTabs,
                "Motivation element 'Our advantages' is present for a wrong category!");
        takeScreenShot("600 Our advantages element is absent for Electronic category");
        //Проверяем, что элемент "Наши примущемтва" присутствует для нужной категорий
        productPage.navigateToApparelCategoryOnStorefront();
        productPage.navigateToMenClothCategoryOnStorefront();
        productPage.chooseClothProduct();
        Assert.assertTrue(productPage.getElementOnProductPage_OurAdvantages().size() >=1,
                "Motivation element is not displayed for a specified category!");
        takeScreenShot("610 Our advantages element is present for Men's cloth category");
    }
}