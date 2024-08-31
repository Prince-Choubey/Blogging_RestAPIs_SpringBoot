package com.codewithprince.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithprince.blog.entities.Comment;
import com.codewithprince.blog.entities.Post;
import com.codewithprince.blog.exceptions.ResouceNotFoundException;
import com.codewithprince.blog.payloads.CommentDto;
import com.codewithprince.blog.repositories.CommentRepo;
import com.codewithprince.blog.repositories.PostRepo;
import com.codewithprince.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResouceNotFoundException("Post", "Post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);

	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResouceNotFoundException("Comment", "Comment id", commentId));
		this.commentRepo.delete(comment);

	}

}
