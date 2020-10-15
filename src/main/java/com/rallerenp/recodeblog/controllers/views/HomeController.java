package com.rallerenp.recodeblog.controllers.views;

import com.rallerenp.recodeblog.services.post.IPostService;
import com.rallerenp.recodeblog.services.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    IPostService postService;
    IUserService userService;

    public HomeController(IPostService postService, IUserService userService)
    {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/new")
    String newPost(Model model)
    {
        return "new";
    }

    @GetMapping("/")
    String index(Model model)
    {
        model.addAttribute("posts", this.postService.getPosts());
        return "index";
    }
}
