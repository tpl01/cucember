package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.BlueRentalPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelReader;
import utilities.ReusableMethods;

public class BlueRentalCarStepDefinition {
    BlueRentalPage rentalPage = new BlueRentalPage();

    @Given("kullanici blueRentalCar sayfasina gider")
    public void kullaniciBlueRentalCarSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
    }

    @But("login butonuna tiklar")
    public void loginButonunaTiklar() {
        rentalPage.loginButonu.click();
        ReusableMethods.bekle(2);
    }

    @Then("email ve password bilgileri ile login olur")
    public void emailVePasswordBilgileriIleLoginOlur() {
        rentalPage.email.sendKeys(ConfigReader.getProperty("email1"), Keys.TAB,
                ConfigReader.getProperty("password1"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }


    @Then("email ve password bilgilerini girer")
    public void emailVePasswordBilgileriniGirer() {
        rentalPage.email.sendKeys(ConfigReader.getProperty("email2"), Keys.TAB,
                ConfigReader.getProperty("password2"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }

    @And("kullanici {string} ve {string} bilgilerini girer")
    public void kullaniciVeBilgileriniGirer(String email, String password) {
        rentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
    }

    @Then("kullanici login oldugunu dogrular")
    public void kullaniciLoginOldugunuDogrular() {
        Assert.assertEquals("https://www.bluerentalcars.com/", Driver.getDriver().getCurrentUrl());
    }


    @And("verilen kullanici bilgileri ile login olur")
    public void verilenKullaniciBilgileriIleLoginOlur(DataTable data) {
        for (int i = 1; i < data.asLists().size(); i++) {
            rentalPage.email.sendKeys(data.row(i).get(0), Keys.TAB, data.row(i).get(1), Keys.ENTER);
            ReusableMethods.bekle(3);
            Driver.getDriver().navigate().back();
            ReusableMethods.bekle(3);
        }
    }

    @And("exceldeki {string} sayfasindaki kullanici bilgileri ile login olunur")
    public void exceldekiSayfasindakiKullaniciBilgileriIleLoginOlunur(String sayfaIsmi) {

        String dosyaYolu="src/test/resources/mysmoketestdata.xlsx";
        ExcelReader excelReader=new ExcelReader(dosyaYolu,sayfaIsmi);
        for (int i=1;i<= excelReader.rowCount();i++){
            String email=excelReader.getCellData(i,0);
            String password=excelReader.getCellData(i,1);
            rentalPage.email.sendKeys(email,Keys.TAB,password,Keys.ENTER);
            ReusableMethods.bekle(2);
            Driver.getDriver().navigate().back();
        }


    }
}


