package com.amit.cruddemobackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Blog_Comment")
public class BlogComment {

	
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int commentId;
		private String commentText;
		@ManyToOne
		private User commentedBy;
		@ManyToOne
		private Blog blogPost;
		public int getCommentId() {
			return commentId;
		}
		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}
		public String getCommentText() {
			return commentText;
		}
		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}
		public User getCommentedBy() {
			return commentedBy;
		}
		public void setCommentedBy(User commentedBy) {
			this.commentedBy = commentedBy;
		}
		public Blog getBlogPost() {
			return blogPost;
		}
		public void setBlogPost(Blog blogPost) {
			this.blogPost = blogPost;
		}
		public Date getCommentedOn() {
			return commentedOn;
		}
		public void setCommentedOn(Date commentedOn) {
			this.commentedOn = commentedOn;
		}
		private Date commentedOn;
		
		}