package com.rallerenp.recodeblog.repositories;

import com.rallerenp.recodeblog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post, Long>
{
    List<Post> getPostsByAuthor_Username(String username);
}
