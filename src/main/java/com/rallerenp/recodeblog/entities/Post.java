package com.rallerenp.recodeblog.entities;

import com.rallerenp.recodeblog.util.JSONObjectable;
import com.sun.istack.NotNull;
import lombok.Data;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post implements JSONObjectable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    String title;

    @NotNull
    String content;

    @ManyToOne(targetEntity = User.class)
    User author;

    @ManyToMany
    List<Tag> tags;

    @Override
    public JSONObject toJSON()
    {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("title", title);
        json.put("content", content);
        json.put("author_id", author.getId());
        return json;
    }
}
