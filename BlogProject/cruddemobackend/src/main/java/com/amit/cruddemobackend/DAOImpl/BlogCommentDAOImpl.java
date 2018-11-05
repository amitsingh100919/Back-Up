package com.amit.cruddemobackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amit.cruddemobackend.DAO.BlogCommentDAO;
import com.amit.cruddemobackend.model.BlogComment;

@Transactional
@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void addBlogComment(BlogComment blogComment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(blogComment);
		
	}

	public List<BlogComment> getBlogComments(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BlogComment where blogPost.blogId=:blogId");
		query.setParameter("blogId", blogId);
		List<BlogComment> blogComments= query.list();
		return blogComments;
	}
	
	

}
