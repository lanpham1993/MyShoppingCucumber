package rough;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v118.browser.Browser;

import com.myshopping.base.Constants;
import com.myshopping.base.SeleniumDriver;
import com.myshopping.pages.ProductPage;
import com.myshopping.pages.menuCategoryBrand;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args) throws InterruptedException{
		 String str = "1/Fer/2020";
	        String[] arrOfStr = str.split("/");
	        for (String a : arrOfStr) {
	            System.out.println(a);
	        }
		String date = "1.Fer.2020";
		String[] datelist = date.split(".");
		 for (String a : datelist) {
	            System.out.println(a);
		 }
	}
}
