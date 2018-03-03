package com.upwork.fb.crawler.domain;

import java.io.Serializable;
import java.util.List;

import facebook4j.Post;
import facebook4j.ResponseList;

/**
 * Domain data structure containg all required data from FB
 * @author sromic
 *
 */
public final class FacebookData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2882958933632950180L;
	
	private final List<String> m_likes;
	
	private final ResponseList<Post> m_posts;
	
	private FacebookData(final List<String> likes, final ResponseList<Post> posts) {
		this.m_likes = likes;
		this.m_posts = posts;
	} 
	
	/**
	 * Static factory method
	 * @param likes
	 * @param posts
	 * @return
	 */
	public static FacebookData newInstance(final List<String> likes, final ResponseList<Post> posts) {
		return new FacebookData(likes, posts);
	}

	public List<String> getLikes() {
		return m_likes;
	}

	public ResponseList<Post> getPosts() {
		return m_posts;
	}
	
}
