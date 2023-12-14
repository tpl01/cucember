package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class GoogleStepDefinition {
    GooglePages googlePages=new GooglePages();


    @Then("arama kutusunda {string} aratir")
    public void aramaKutusundaAratir(String str) {
        googlePages.aramaKutusu.sendKeys(str, Keys.ENTER);

    }

    @When("sayfa basliginin {string} icerdigini test eder")
    public void sayfaBasligininIcerdiginiTestEder(String str) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(str));

    }

    @And("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int saniye) {
        try {
            Thread.sleep(1000*saniye);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici parametreli method ile propertiesden {string} sayfasina gider")
    public void kullaniciParametreliMethodIlePropertiesdenSayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("arama kutusunda propertiesden {string} aratir")
    public void aramaKutusundaPropertiesdenAratir(String str) {
        googlePages.aramaKutusu.sendKeys(ConfigReader.getProperty(str),Keys.ENTER);
    }

    @When("sayfa basliginin propertiesden {string} icerdigini test eder")
    public void sayfaBasligininPropertiesdenIcerdiginiTestEder(String str) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty(str)));
    }

    @Then("arama kutusunda belirtilen {string} aratir")
    public void aramaKutusundaBelirtilenAratir(String arac) {
        googlePages.aramaKutusu.sendKeys(arac,Keys.ENTER);
    }

    @When("kullanici sayfa basliginin {string} icerdigini test eder")
    public void kullaniciSayfaBasligininIcerdiginiTestEder(String arac) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(arac));
    }

    @Then("arama kutusunda propertiesden belirtilen {string} aratir")
    public void aramaKutusundaPropertiesdenBelirtilenAratir(String arac) {

        googlePages.aramaKutusu.sendKeys(ConfigReader.getProperty(arac),Keys.ENTER);
    }

    @When("kullanici sayfa basliginin propertiesden {string} icerdigini test eder")
    public void kullaniciSayfaBasligininPropertiesdenIcerdiginiTestEder(String arac) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty(arac)));
    }

    @Then("kullanici verilen bilgiler ile arama yapar")
    public void kullaniciVerilenBilgilerIleAramaYapar(DataTable data) {

        List<String> dataTableList=data.asList();
        System.out.println(data.asList());
        for(int i=1;i< dataTableList.size();i++){
         googlePages.aramaKutusu.sendKeys(data.asList().get(i),Keys.ENTER);
            ReusableMethods.bekle(2);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(dataTableList.get(i)));
            googlePages.aramaKutusu.clear();   //yazip silsin diye
        }

    }

    @When("kullanici verilen bilgiler ile arama yapar ikinci yol")
    public void kullaniciVerilenBilgilerIleAramaYaparIkinciYol(List<String>list) {

        for (String w :list  ) {
            googlePages.aramaKutusu.sendKeys(w+Keys.ENTER);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(w));
            googlePages.aramaKutusu.clear();
        }

    }
}
