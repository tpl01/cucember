package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//Cucumber ile junit'in entegre olmasını sağlayan scenario çalıştırıcı notasyonu

@CucumberOptions(plugin = {"pretty",  //pretty->konsolda scenariolar ile ilgili ayrıntılı bilgi verir
        "html:target/default-cucumber-reports1.html",
        "json:target/json-reports/cucumber1.json",
        "junit:target/xml-report/cucumber1.xml",
        "rerun:TestOutput/failed_scenario.txt"},
        features = "src/test/resources/features", //features package'ının yolu (content root)
        glue = "stepDefinitions", //stepDefinitions package ismi
        tags = "@US013", //Hangi scenarioları bu tag'ı belirtirsek o scenariolar çalışır
        //@US001 or @US002  olabilir
        dryRun = false, //true seçersek scenariolari kontrol eder browser'ı çalıştırmaz
        //step definetionlarda eksik varmi kontrol eder (true dersek)
        monochrome = true//-->true kullanırsak konsoldaki çıktıları tek renk(siyah) olarak verir
)
         /*
        rerun plugin'i ile fail olan scenarioları failed_scenario.txt dosyası içinde tutabiliriz.
         */


public class Runner {
    /*
        @CucumberOptions() bu notasyon sayesinde hangi scenariolari çalıştıracağımızı ve hangi raporları
    alacağımızı belirtiriz
        dryRun parametresi eğer true seçilirse scenariolari çalıştırmadan feature file daki steplerin
    stepDefinition class'ındaki methodlar ile uyuşuğ uyuşmadığını kontrol eder ve browser'ı çalıştırmaz
     */

    /*

    .Runner clasin bodysi bos olur
    .önemli  tane notasyon vardir
      1)@RunWith
      2)@CucumberOptions

     */

}