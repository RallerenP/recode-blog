package com.rallerenp.recodeblog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostDTO
{
    private String title;
    private String content;
    private long authorId;
}
