package com.rallerenp.recodeblog.entities;

public enum UserRole
{
    GUEST
    {
        @Override
        public String toString()
        {
            return "Guest";
        }
    },
    ADMIN
    {
        @Override
        public String toString()
        {
            return "Admin";
        }
    }
}
