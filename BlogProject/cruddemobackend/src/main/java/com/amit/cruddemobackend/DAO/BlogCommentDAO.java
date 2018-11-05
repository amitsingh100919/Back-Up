package com.amit.cruddemobackend.DAO;

import java.util.List;

import com.amit.cruddemobackend.model.BlogComment;

public interface BlogCommentDAO {

	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getBlogComments(int blogId);
}
    