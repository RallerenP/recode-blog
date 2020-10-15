package com.rallerenp.recodeblog.services.post;

import com.rallerenp.recodeblog.dtos.CreatePostDTO;
import com.rallerenp.recodeblog.dtos.CreateUserDTO;
import com.rallerenp.recodeblog.entities.Post;
import com.rallerenp.recodeblog.entities.User;
import com.rallerenp.recodeblog.exceptions.RecodeServiceException;
import com.rallerenp.recodeblog.repositories.IPostRepository;
import com.rallerenp.recodeblog.repositories.IUserRepository;
import com.rallerenp.recodeblog.services.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService
{
    IPostRepository postRepository;
    IUserService userService;
    IUserRepository userRepository; // Purely for dummy data creation

    public PostService(IPostRepository postRepository, IUserService userService) throws RecodeServiceException
    {
        this.postRepository = postRepository;
        this.userService = userService;

//         Create Dummy Data
//        CreateUserDTO dto1 = new CreateUserDTO();
//        dto1.setUsername("RallerenP");
//        dto1.setPassword("Password1");
//        dto1.setEmail("test@rallerenp.dk");
//        User u1 = userService.createUser(dto1);
//
//        Post p1 = new Post();
//        p1.setAuthor(u1);
//        p1.setContent("This is a test post on the platform");
//        p1.setTitle("The First Test Post");
//
//        u1.getPosts().add(p1);
//        this.userService.save(u1);
//        this.postRepository.save(p1);
//
//        CreateUserDTO dto2 = new CreateUserDTO();
//        dto2.setUsername("SørenMand");
//        dto2.setPassword("Password1");
//        dto2.setEmail("søren@mand.dk");
//        User u2 = userService.createUser(dto2);
//
//        Post p2 = new Post();
//        p2.setAuthor(u2);
//        p2.setTitle("ReCode Blog");
//        p2.setContent("Just another Test");
//        u2.getPosts().add(p2);
//        this.userService.save(u2);
//        this.postRepository.save(p2);
    }

    @Override
    public Post createPost(CreatePostDTO dto)
    {
        String title = dto.getTitle();
        String content = dto.getContent();
        User author = this.userService.getUserById(dto.getAuthorId());

        Post p = new Post();
        p.setTitle(title);
        p.setContent(content);
        p.setAuthor(author);

        p = this.postRepository.save(p);
        return p;
    }

    @Override
    public List<Post> getPosts()
    {
        return this.postRepository.findAll();
    }
}
