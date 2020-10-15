package com.rallerenp.recodeblog.repositories;

import com.rallerenp.recodeblog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>
{
    User getUserById(long id);
    User getUserByUsername(String username);
}
