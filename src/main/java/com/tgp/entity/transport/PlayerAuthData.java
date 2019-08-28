package com.tgp.entity.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAuthData {
    @NonNull
    private String login;
    @NonNull
    private String password;
}
