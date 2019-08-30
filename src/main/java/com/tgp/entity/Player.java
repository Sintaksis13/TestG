package com.tgp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return login.equals(player.login) &&
                password.equals(player.password) &&
                fullName.equals(player.fullName) &&
                email.equals(player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fullName, email);
    }
}