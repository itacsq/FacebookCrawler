/**
 * 
 */
package com.upwork.fb.crawler.web;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

/**
 * @author sromic
 *
 */
public final class FacebookPostCrawler {

	// Get an access token from: 
    // https://developers.facebook.com/tools/explorer
	private static final String ACCESS_TOKEN = "CAACEdEose0cBAL6c4jqaoyvwA6DZBtTFZBBekrZBQ56iwYA2uOIqPMVx3669s8eAJoiAZAoIBZB0apw9I4QdhRUZAxQgekrUvfM0eB8ldRGOom7w9kXT0VWNvINqSZBAHyhZB0G1ZCGTTzBTG9vX4wSRmghZBredTMifqmrHoEuoiLHhTWSH1PDsqDXfALm8bQv8EdC5VEKT6LfG0wxBgPNECH";
	
	/**
	 * Return post from given page
	 * @param email
	 * @param password
	 * @param pageId
	 * @return
	 * @throws FacebookException
	 */
	public static ResponseList<Post> getPagePosts(final String email, final String password, final String pageId) throws FacebookException {
		// Generate facebook instance.
	    final Facebook facebook = new FacebookFactory().getInstance();
	    // Use default values for oauth app id.
	    facebook.setOAuthAppId(email, password);
	    
	    final AccessToken at = new AccessToken(ACCESS_TOKEN);
	    // Set access token.
	    facebook.setOAuthAccessToken(at);
	    
	    return facebook.getFeed(pageId, new Reading());
	}
}
