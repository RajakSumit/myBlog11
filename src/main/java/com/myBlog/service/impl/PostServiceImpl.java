package com.myBlog.service.impl;

import com.myBlog.entity.Post;
import com.myBlog.exception.ResourceNotFoundException;
import com.myBlog.payload.PostDto;
import com.myBlog.repository.PostRepository;
import com.myBlog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private ModelMapper modelMapper;



    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);

        PostDto dto = mapToDto(savedPost);


        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id:"+id)  //using supplier functional interface

        );

//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());

        PostDto dto = mapToDto(post);
        return dto;
    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {

        //  Using Ternary Operator
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort); // this is to giving direction for sorting

//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy)); //this will short in ascending order

        Page<Post> pagePost = postRepository.findAll(pageable);

        List<Post> posts = pagePost.getContent();

        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public void deletePpost(long Id) {
        postRepository.deleteById(Id);
    }

    PostDto mapToDto(Post post){

        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());

    }

    Post mapToEntity(PostDto postDto){

        Post post = modelMapper.map(postDto, Post.class);
        return post;
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

    }
}
