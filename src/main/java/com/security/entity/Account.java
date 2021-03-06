package com.security.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"login","password"})
@Entity
public class Account {

    @Id
    @Column(length = 100)
    private String login;

    private String password;

    /*    @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)*/
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "role")
    private List <Role> roles = new ArrayList <>();

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
