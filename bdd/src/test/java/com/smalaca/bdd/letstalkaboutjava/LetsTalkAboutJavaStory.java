package com.smalaca.bdd.letstalkaboutjava;

import com.smalaca.bdd.jbehave.JBehaveConfiguration;
import com.smalaca.bdd.properties.ConfigPropertiesFactory;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LetsTalkAboutJavaStory extends JBehaveConfiguration {
    private ChromeDriver driver;

    @BeforeScenario
    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", new ConfigPropertiesFactory().read().getChromeWebDriverPath());
        driver = new ChromeDriver();
    }

    @AfterScenario
    public void closeChromeDriver() {
        driver.close();
    }

    @When("visiting Let's talk about Java blog")
    public void whenVisitLetsTalkAboutJavaBlog() {
        driver.navigate().to("https://letstalkaboutjava.blogspot.com/");
    }

    @Then("let's talk about Java should be reach")
    public void thenLetsTalkAboutJavaBlogShouldBeReach() {
        assertThat(driver.getCurrentUrl()).isEqualTo("https://letstalkaboutjava.blogspot.com/");
        assertThat(driver.getTitle()).isEqualTo("let's talk about Java");
    }

    @When("opening Who am I page")
    public void whenOpeningWhoAmIPage() {
        WebElement linkWhoAmI = driver.findElement(By.linkText("Who am I?"));
        linkWhoAmI.click();
    }

    @Then("Who am I page should be reach")
    public void thenWhoAmIPageShouldBeReach() {
        assertThat(driver.getCurrentUrl()).isEqualTo("https://letstalkaboutjava.blogspot.com/p/who-am-i.html");
        assertThat(driver.getTitle()).isEqualTo("let's talk about Java: Who am I?");
    }
}
