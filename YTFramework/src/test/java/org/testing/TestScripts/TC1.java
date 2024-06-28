package org.testing.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.Base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1 extends Base{
	
	@Test
	public void trending() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(pr.getProperty("trending"))).click();
		Thread.sleep(3000);
	}
}


//List<String> list = new ArrayList<String>(Arrays.asList("XXXXXXXXXXXXXXX","b"));
//System.out.println(list.get(0));


//Home, Shorts, Subscriptions, You, History, Playlists, Watch later, Liked videos, Downloads, Trending, Music, Gaming, News, Sports, Learning, Podcasts, 
//YouTube Premium, YouTube Music, YouTube Kids, Settings, Report history, Help, Send feedback
//driver.findElement(By.xpath("//yt-formatted-string[@class='title style-scope ytd-guide-entry-renderer' and normalize-space()='']")).click();




