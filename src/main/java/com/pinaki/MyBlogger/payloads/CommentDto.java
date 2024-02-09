package com.pinaki.MyBlogger.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
	private int id;
	private String content;
}
