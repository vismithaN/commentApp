package com.zoho.comment.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zoho.comment.Database.Comments;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @Column(name = "email_id")
    private String emailID;
    @Column(name = "password")
    private String password;
    @Column(name = "secret_code")
    private String secretCode;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comments> commentsList;
}
