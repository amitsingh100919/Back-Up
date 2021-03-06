package com.amit.cruddemobackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amit.cruddemobackend.DAO.BlogDAO;
import com.amit.cruddemobackend.DAO.UserDAO;
import com.amit.cruddemobackend.model.Blog;
import com.amit.cruddemobackend.model.User;

public class BlogDAOTest {
	
	private static AnnotationConfigApplicationContext context=null;
	private static BlogDAO blogDAO=null;
	private static UserDAO userDAO;
	private static Blog blog=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.amit.cruddemobackend");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		blog=new Blog();
	}

	@Test
	public void testCreateBlog() {
		blog.setBlogTitle("about friends");
		blog.setBlogContent("amsdndjdjggkf");
		blog.setPostedBy("ab");
		blog.setPostedOn("my blogs");
		//blog.setUserName("amit singh");
		blog.setStatus("A");
		blog.setLiked(4);
		//blog.setSharein(5);
		//blog.setSharedBy("bhanoo sir");
		assertTrue("Blog record not inserted",blogDAO.createBlog(blog));
	}

	@Ignore
	@Test
	public void testUpdateBlog() {
		
	}

	@Ignore
	@Test
	public void testDeleteBlog() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetBlogById() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testApprovedBlogList() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testNotApprovedBlogList() {
		fail("Not yet implemented");
	}

}
