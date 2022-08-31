package com.example.testjwt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;
    private String email;
    private String sdt;
    @ManyToMany(fetch = FetchType.EAGER )
    private List<Role> roles;
}
