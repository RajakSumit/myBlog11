package com.myBlog.service;

import com.myBlog.payload.CommentDto;

public interface CommentService {

        CommentDto createComment(CommentDto commentDto, long postId);

        void deleteComment(long id);

        CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
