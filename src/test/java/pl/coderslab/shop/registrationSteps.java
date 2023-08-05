package pl.coderslab.shop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class registrationSteps {
    WebDriver driver;

    @Given("I'm on the shop page")
    public void ImOnTheShopPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
   }

   @When("I click on {string} button")
   public void iClickOnButton(String arg0) {
        driver.findElement(By.className("user-info")).click();
    }

    @Then("I click {string} button")
    public void iClickButton(String arg0) {
        driver.findElement(By.className("no-account")).click();
    }

    @And("I fill in new account form using data Social Title {string} First name {string} Last Name {string} email {string} Password {string} Birthdate {string}")
    public void iFillInNewAccountFormUsingDataSocialTitleFirstNameLastNameEmailPasswordBirthdate(String SocialTitle, String FirstName, String LastName, String Email, String Password, String Birthdate) {
        Date currentdate = new Date();
        String date = currentdate.toString().replace(" ", "-").replace(":", "-");
        System.out.println(date);
            driver.findElement(By.id("field-id_gender-2")).click();
            driver.findElement(By.name("firstname")).sendKeys(FirstName);
            driver.findElement(By.name("lastname")).sendKeys(LastName);
            driver.findElement(By.name("email")).sendKeys(Email + date);
            driver.findElement(By.id("field-password")).sendKeys(Password + date);
            driver.findElement(By.id("field-birthday")).sendKeys(Birthdate);
        }

    @Then("I check on {string} box and {string} box")
    public void iCheckOnBoxAndBox(String arg0, String arg1) {
        driver.findElement(By.name("customer_privacy")).click();
        driver.findElement(By.name("psgdpr")).click();
    }

    @And("I can click on {string} button")
    public void iCanClickOnButton(String arg0) {
        driver.findElement(By.xpath("//button[@class='btn btn-primary form-control-submit float-xs-right']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I enter my account and I click {string}")
    public void iEnterMyAccountAndIClick(String arg0) {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        driver.findElement(By.xpath("//a[@data-link-action='add-address']")).click();
  }

   @And("I enter new: alias {string} Address {string} City {string} PostalCode {string} Country {string} Phone {string}")
   public void iEnterNewAliasAddressCityPostalCodeCountryPhone(String alias, String Address, String City, String PostalCode, String Country, String Phone) {
      driver.findElement(By.name("alias")).sendKeys(alias);
       driver.findElement(By.name("address1")).sendKeys(Address);
      driver.findElement(By.name("city")).sendKeys(City);
      driver.findElement(By.name("postcode")).sendKeys(PostalCode);
      driver.findElement(By.id("field-id_country")).sendKeys(Country);
      driver.findElement(By.name("phone")).sendKeys(Phone);
   }

    @Then("I save")
    public void iSave() {
        driver.findElement(By.className("form-control-submit")).click();
  }
   @Then("I quit")
    public void iQuit() {
        driver.quit();

    }
}
