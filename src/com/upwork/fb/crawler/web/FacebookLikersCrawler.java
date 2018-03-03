package com.upwork.fb.crawler.web;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public final class FacebookLikersCrawler {

	private static final String FACEBOOK_PAGE_LIKERS = "/likers";
	private static final String FACEBOOK_URL = "https://www.facebook.com/login.php?login_attempt=1&lwv=100";
	private static final String FACEBOOK_PAGE_SEARCH = "https://www.facebook.com/search/";
	
	public static List<String> getPageLikers(final String email, final String password, final String pageId)  {
		LogManager.getLogManager().reset();
		final WebDriver driver = new HtmlUnitDriver(true);
        driver.get(FACEBOOK_URL);
        
        //this way we can use cookies returned from response in next requests
        //populate login form and submit it
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_2")).submit();
        
        System.out.println(FACEBOOK_PAGE_SEARCH);
        System.out.println(FACEBOOK_PAGE_LIKERS);
        System.out.println(FACEBOOK_PAGE_SEARCH + pageId + FACEBOOK_PAGE_LIKERS);
        //after successful login, ask for page likers search;
		//driver.get(FACEBOOK_PAGE_SEARCH + pageId + FACEBOOK_PAGE_LIKERS);
		driver.get("https://www.facebook.com/SAS-Esp-149102852110068/notifications");
        System.out.println(driver.getPageSource());
        try{
	        PrintWriter out = new PrintWriter("filename.html");
	        out.println(driver.getPageSource());
        }
        catch(Exception e){}
        
        List<String> rets = new ArrayList<String>();
        try{
        	rets = driver.findElements(By.className("_1sww")).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
        }catch(Exception e){
        	
        }
        
        
		return rets;
	}
}
