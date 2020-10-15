package com.rallerenp.recodeblog.services.user;

import com.rallerenp.recodeblog.dtos.CreateUserDTO;
import com.rallerenp.recodeblog.entities.User;
import com.rallerenp.recodeblog.exceptions.RecodeServiceException;

public interface IUserService
{
    User createUser(CreateUserDTO dto) throws RecodeServiceException;
    User getUserById(long id);
    User getUserByUsername(String username);
    User save(User u);
}
