package com.upwork.fb.crawler.factory;

import java.util.List;

import com.upwork.fb.crawler.domain.FacebookData;
import com.upwork.fb.crawler.web.FacebookLikersCrawler;
import com.upwork.fb.crawler.web.FacebookPostCrawler;

import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.ResponseList;

public final class FacebookCrawlerFactory {
	
	final String m_email;
	
	final String m_password;
	
	final String m_pageId;

	private FacebookCrawlerFactory(String email, String password, String pageId) {
		this.m_email = email;
		this.m_password = password;
		this.m_pageId = pageId;
	}
	
	/**
	 * Static factory method
	 * @param email
	 * @param password
	 * @param pageId
	 * @return
	 */
	public static FacebookCrawlerFactory newInstance(final String email, final String password,
			final String pageId) {
		return new FacebookCrawlerFactory(email, password, pageId);
	}
	
	/**
	 * Begin process of getting FB data
	 * @return
	 */
	public FacebookData makeRequest() {
		
		final List<String> pageLikers = FacebookLikersCrawler.getPageLikers(m_email, m_password, m_pageId);
		System.out.println("Likes: " + pageLikers.size());
		for(String s : pageLikers){
			
			System.out.println(s);
		}
		
		ResponseList<Post> pagePosts = null;
		try {
			pagePosts = FacebookPostCrawler.getPagePosts(m_email, m_password, m_pageId);
			System.out.println("Messages: " + pagePosts.size());
			for(Post p : pagePosts){
				
				System.out.println(p.getMessage());
			}
			
		} catch (FacebookException e) {
			e.printStackTrace();
		}
		
		return FacebookData.newInstance(pageLikers, pagePosts);
	} 

	public String getEmail() {
		return m_email;
	}

	public String getPassword() {
		return m_password;
	}

	public String getPageId() {
		return m_pageId;
	}
	
	
}
