package com.blogmiddleware.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.cruddemobackend.DAO.BlogCommentDAO;
import com.amit.cruddemobackend.DAO.UserDAO;
import com.amit.cruddemobackend.model.Blog;
import com.amit.cruddemobackend.model.BlogComment;
import com.amit.cruddemobackend.model.User;

@RestController
public class BlogCommentController {
	
	@Autowired
	private BlogCommentDAO blogCommentDAO;
	@Autowired
	private UserDAO userDAO;
	
	
	@PostMapping(value="/addBlogComment/{commentText}")
	public ResponseEntity<?> addBlogComment(@RequestBody Blog blog,@PathVariable("commentText") String commentText ,HttpSession httpSession)
	{
		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		
		BlogComment blogComment = new BlogComment();
		blogComment.setCommentText(commentText);
		blogComment.setBlogPost(blog);
		User user = userDAO.getUserByEmail(email);
		blogComment.setCommentedBy(user);
		
		blogCommentDAO.addBlogComment(blogComment);
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	
	
	@GetMapping("/getComments/{blogId}")
	public ResponseEntity<?> getComments(@PathVariable("blogId") int blogId,HttpSession httpSession)
	{

		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		 List<BlogComment> blogComments = blogCommentDAO.getBlogComments(blogId);
		 return new ResponseEntity< List<BlogComment>>(blogComments,HttpStatus.OK); 
	}

}
