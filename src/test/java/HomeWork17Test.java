import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17Test extends BaseTest {


    @Test

    public void addSongToPlaylist() throws InterruptedException {

            String expectedSongAddedMessage = "Added 1 song into \"Rosya.\"";

            navigateToUrl();
            provideEmail("ruslan.bohonosyuk@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            searchSong("Midnight in Mississippi");
            clickViewAllBtn();
            selectFirstSongResult();
            clickAddToBtn();
            choosePlaylist();
            Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement (By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement (By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Rosya')]"));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
    
}

