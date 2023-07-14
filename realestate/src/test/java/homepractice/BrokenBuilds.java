package homepractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenBuilds {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//driver.findElement(By.xpath("//button[text()='✕']")).click();
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		ArrayList<Object> brokenLinks=new ArrayList<Object>();
		for(int i=0;i<links.size();i++)
         {
	String allLinks = links.get(i).getAttribute("href");
	URL url;
	int statusCode=0;
	try {
		url=new URL(allLinks);
		URLConnection connection=url.openConnection();
		HttpURLConnection HttpURLConnection=(HttpURLConnection) connection;
		statusCode=HttpURLConnection.getResponseCode();
		if(statusCode>=400)
		{
			brokenLinks.add(allLinks+" "+statusCode);
		}
	}
	catch(Exception e)
	{
		continue;
	}
}
		System.out.println(brokenLinks);
		driver.close();

	}

}
