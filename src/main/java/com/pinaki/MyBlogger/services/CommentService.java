package com.pinaki.MyBlogger.services;

import com.pinaki.MyBlogger.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto, Integer postId);
	void deleteComment(Integer commentId);
}
