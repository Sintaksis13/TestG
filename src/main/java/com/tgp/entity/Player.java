package com.tgp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String fullName;
    @NonNull
    private String email;
    private Date registerDate;

    @PrePersist
    private void setRegisterDate() {
        this.registerDate = new Date();
    }
}