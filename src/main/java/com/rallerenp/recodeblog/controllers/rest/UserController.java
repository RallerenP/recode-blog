package com.rallerenp.recodeblog.controllers.rest;

import com.rallerenp.recodeblog.dtos.CreateUserDTO;
import com.rallerenp.recodeblog.exceptions.RecodeServiceException;
import com.rallerenp.recodeblog.services.user.IUserService;
import com.rallerenp.recodeblog.util.JSONObjectable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController()
@RequestMapping("/api/users/")
public class UserController
{
    IUserService userService;

    public UserController(IUserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@Valid @RequestBody() CreateUserDTO dto, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        try
        {
            JSONObjectable user = this.userService.createUser(dto);
            session.setAttribute("userId", user.toJSON().get("id"));
            return new ResponseEntity<>(user.toJSON().toString(), HttpStatus.OK);
        }
        catch (RecodeServiceException e)
        {
            return new ResponseEntity<>(e.toJSON().toString(), HttpStatus.CONFLICT);
        }
    }

}
