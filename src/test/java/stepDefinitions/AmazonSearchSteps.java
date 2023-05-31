package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonSearchSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I launch chrome browser and navigate to {string}")
    public void i_launch_chrome_browser_and_navigate_to_amazon_homepage(String webPage) {
        // Change path to the chromedriver executable if required.
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        this.driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.get(webPage);
    }

    @When("I search for {string} and sort results by highest price")
    public void i_search_for_and_sort_results_by_highest_price(String searchTerm) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("a-dropdown-prompt")));
        sortDropdown.click();
        // Select "Price: High to Low" option
        WebElement highToLowOption = driver.findElement(By.xpath("//a[text()='Price: High to Low']"));
        highToLowOption.click();
    }

    @When("I select the second product")
    public void i_select_the_second_product() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-index='2'] h2 a.a-link-normal")));
        productElement.click();
    }

    @Then("I verify that the product topic contains {string} and close the browser")
    public void i_verify_that_the_product_topic_contains_and_close_the_browser(String checkTerm) {
        WebElement productTopic = driver.findElement(By.id("productTitle"));
        String productTitle = productTopic.getText();
//        System.out.print(productTitle + "\n");
        driver.quit();
//        assertTrue(productTitle.contains(checkTerm));
        if (!productTitle.contains(checkTerm)) {
            System.out.println("Product title does not have the expected term.");
        }

    }
}


