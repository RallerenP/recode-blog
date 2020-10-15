package com.rallerenp.recodeblog.services.user;

import com.rallerenp.recodeblog.dtos.CreateUserDTO;
import com.rallerenp.recodeblog.entities.User;
import com.rallerenp.recodeblog.exceptions.RecodeServiceException;
import com.rallerenp.recodeblog.repositories.IUserRepository;
import com.rallerenp.recodeblog.services.hash.IHashService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
    IHashService hashService;
    IUserRepository userRepository;

    public UserService(IHashService hashService, IUserRepository userRepository)
    {
        this.hashService = hashService;
        this.userRepository = userRepository;



    }

    @Override
    public User createUser(CreateUserDTO dto) throws RecodeServiceException
    {


        String username = dto.getUsername();

        if (this.userRepository.getUserByUsername(username) != null) throw new RecodeServiceException("An user with username '" + username + "' already exists.");

        String pass = this.hashService.hash(dto.getPassword()); // Hash password before storing.
        String email = dto.getEmail();

        User u = new User();

        u.setUsername(username);
        u.setPassword(pass);
        u.setEmail(email);

        this.userRepository.save(u);

        return this.getUserByUsername(username);
    }

    @Override
    public User getUserById(long id)
    {
        return this.userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username)
    {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public User save(User u)
    {
        return this.userRepository.save(u);
    }
}
