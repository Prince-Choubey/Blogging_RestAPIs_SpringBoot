package com.codewithprince.blog.services;

import java.util.List;

import com.codewithprince.blog.entities.Post;
import com.codewithprince.blog.payloads.PostDto;
import com.codewithprince.blog.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get All Post
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

	// get single post
	PostDto getPostById(Integer postId);

	// get All Post By Category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get All Posts By User
	List<PostDto> getPostsByUser(Integer userId);

	// Search Posts
	List<PostDto> searchPosts(String keyword);

}
