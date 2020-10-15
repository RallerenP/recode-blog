package com.rallerenp.recodeblog.services.post;

import com.rallerenp.recodeblog.dtos.CreatePostDTO;
import com.rallerenp.recodeblog.entities.Post;

import java.util.List;

public interface IPostService
{
    Post createPost(CreatePostDTO dto);
    List<Post> getPosts();
}
