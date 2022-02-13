package com.zoho.comment.Database;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Comments {
    @Id
    private int id;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
