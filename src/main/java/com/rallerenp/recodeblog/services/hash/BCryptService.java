package com.rallerenp.recodeblog.services.hash;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BCryptService implements IHashService
{

    @Override
    public String hash(String value)
    {
        return BCrypt.hashpw(value, BCrypt.gensalt());
    }

    @Override
    public boolean validate(String value, String hashed)
    {
        return  BCrypt.checkpw(value, hashed);
    }
}
