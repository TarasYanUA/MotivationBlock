package taras.workPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;

public class MapsAndGeolocation extends AbstractPage {
    public MapsAndGeolocation(){super();}

    @FindBy(xpath = "//select[contains(@id, 'addon_option_geo_maps_provider')]")
    WebElement dropboxValue_Service;

    @FindBy(xpath = "//input[contains(@id, 'addon_option_geo_maps_show_shippings_on_product')]")
    public WebElement checkbox_ShowShippingCost;

    @FindBy(id = "geo_maps_google")
    public WebElement tab_Google;

    @FindBy(xpath = "//input[contains(@id, 'addon_option_geo_maps_google_api_key')]")
    WebElement google_ApiKey;


    private Select getDropboxValue_Service(){
        return new Select(dropboxValue_Service);
    }
    public void selectDropboxValue_Service(String value){
        getDropboxValue_Service().selectByValue(value);
    }

    public void clickAndType_GoogleApiKey() {
        google_ApiKey.click();
        google_ApiKey.sendKeys("AIzaSyBN51Tl05m8bPKtgHswOGtllu_TO3_bEN8");
    }
}
