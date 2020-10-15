package com.rallerenp.recodeblog.services.hash;

public interface IHashService
{
    String hash(String value);
    boolean validate(String value, String hashed);
}
