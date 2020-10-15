package com.rallerenp.recodeblog.entities;

import com.rallerenp.recodeblog.util.JSONObjectable;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // Lombok data annotation (auto create getter, setter, equals, hashcode, etc..)
public class User implements JSONObjectable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @OneToMany(targetEntity = Post.class)
    List<Post> posts;

    private UserRole role = UserRole.GUEST;

    @Override
    public JSONObject toJSON()
    {
        JSONObject json = new JSONObject();

        json.put("id", id);
        json.put("username", username);
        json.put("email", email);
        json.put("role", role.toString());

        return json;
    }
}
