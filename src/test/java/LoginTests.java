import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
//    @Test
//    public void loginEmptyEmailPassword() {
//
////      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
//    }
//}

    @Test
    public void navigateToKoelApp() {
        navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {
        try {
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();
            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        provideEmail("invalid@class.com");
        //Password Field
        providePassword("te$t$tudent");
        //Submit button
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {
        //navigateToUrl();
        //Email Field
        provideEmail("demo@class.com");
        //Password Field
        providePassword("invalidPassword");
        //Submit button
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


}