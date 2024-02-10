package com.myBlog.service.impl;

import com.myBlog.entity.Comment;
import com.myBlog.entity.Post;
import com.myBlog.exception.ResourceNotFoundException;
import com.myBlog.payload.CommentDto;
import com.myBlog.repository.CommentRepository;
import com.myBlog.repository.PostRepository;
import com.myBlog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found With Id:" + postId)
        );

        Comment comment = new Comment();

        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment SavedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setEmail(SavedComment.getEmail());
        dto.setText(SavedComment.getText());

        return dto;
    }

    @Override
    public void deleteComment(long id) {

        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow
                (() -> new ResourceNotFoundException("Post Not Found By Id: " + id));

        Comment comments = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found By Id: " + id));

        Comment c = mapToEntity(commentDto);
        c.setId(comments.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);

        CommentDto dto = mapToDto(savedComment);

        return dto;
    }

    CommentDto mapToDto(Comment comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;

    }

    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;

    }
}
