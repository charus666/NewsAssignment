package test.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class NewsStepDefination {

    public static WebDriver driver;
    private EnvironmentVariables environmentVariables;



    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/webdriver/windows/chromedriver.exe");
        driver = new ChromeDriver();


    }

//    @After
//    public void tearDown()
//    {
//        driver.quit();
//    }

    @Given("the user is on NSW Government News Page")
    public void the_user_is_on_NSW_Government_News_Page()
    {
    driver.get("https://www.nsw.gov.au/news");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    assertEquals("News | NSW Government",driver.getTitle());
    }

    @When("he click on Select Topics Button")
    public void he_click_on_Select_Topics_Button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element;
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"search-filter__toggle\" and contains(., 'Select topics ') ]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    @When("Selects {string} and clicks Apply")
    public void selects_One_or_More_Topics_and_clicks_Apply(String Topic) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String topicXpath="//label[contains(text(),'"+Topic+"')]";
        driver.findElement(By.xpath(topicXpath)).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element;
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"submit\"])[1]")));
        element.click();


    }

    @Then("the News Item Cards will be filtered based on the {string} Selected")
    public void the_News_Item_Cards_will_be_filtered_based_on_the_Topics_Selected(String TopicName) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String str= "(//p[text()=\""+TopicName+"\"])[1]";
        String str1= driver.findElement(By.xpath(str)).getText();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element;
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
        assertEquals(TopicName,element.getText());
        //Thread.sleep(10000);

    }

    @Then("when any filter applies user see {string} button")
    public void when_any_filter_applies_user_see_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @Then("when user click on the Reset button")
    public void when_user_click_on_the_Reset_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement resetButton;
        resetButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"submit\"])[2]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"submit\"])[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(resetButton);
        actions.perform();
        resetButton.click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//input[@type=\"submit\"])[2]")).click();
       // Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type=\"submit\"])[1]")));
    }

    @Then("the filters are removed from the selected {string}")
    public void the_filters_are_removed_on_the_news_items(String Topic) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//button[@class=\"search-filter__toggle\" and contains(., 'Select topics ') ]")).click();
        String topicXpath="//label[contains(text(),'"+Topic+"')]";
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element;
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(topicXpath)));
        boolean x = element.isSelected();
        assertEquals(false,x);
        Thread.sleep(10000);
    }


}
