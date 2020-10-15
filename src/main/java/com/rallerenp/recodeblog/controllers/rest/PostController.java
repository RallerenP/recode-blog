package com.rallerenp.recodeblog.controllers.rest;

import com.rallerenp.recodeblog.dtos.CreatePostDTO;
import com.rallerenp.recodeblog.services.post.IPostService;
import com.rallerenp.recodeblog.util.JSONObjectable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController
{
    IPostService postService;

    public PostController(IPostService postService)
    {
        this.postService = postService;
    }

    @PostMapping("/")
    ResponseEntity<String> addPost(@Valid @RequestBody CreatePostDTO dto)
    {
        JSONObjectable entity = this.postService.createPost(dto);

        return new ResponseEntity<>(entity.toJSON().toString(), HttpStatus.OK);
    }
}
