import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class HomeWork18Test extends BaseTest{

    @Test
    public void playSong(){
        provideEmail("ruslan.bohonosyuk@testpro.io");
        providePassword("te$tStudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());

    }

    public void clickPlay(){
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn'"));

        playNextButton.click();
        playButton.click();

    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='play-btn']"));
        return soundBar.isDisplayed();
    }

}
