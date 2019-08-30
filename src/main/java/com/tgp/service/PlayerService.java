package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.exception.IllegalStatusException;
import com.tgp.repository.PlayerRepository;
import com.tgp.service.response.ResponseEntity;
import com.tgp.service.response.ResponseStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Player> registerPlayer(String login, String password, String fullName, String email) {
        Player byLogin = repository.findByLogin(login);
        Player byEmail = repository.findByEmail(email);
        ResponseEntity<Player> response;
        try {
            if (byEmail == null && byLogin == null) {
                Player savedPlayer = repository.save(new Player(login, password, fullName, email));
                response = generateResponse(savedPlayer, ResponseStatus.ACCOUNT_CREATED);
            } else if (byLogin != null) {
                response = generateResponse(byLogin, ResponseStatus.LOGIN_NOT_VACANT);
            } else {
                response = generateResponse(byEmail, ResponseStatus.EMAIL_NOT_VACANT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(null, "Internal error", ResponseStatus.INTERNAL_ERROR);
        }

        return response;
    }

    public ResponseEntity<Player> checkPlayerForAuth(String login, String password) {
        Player dbPlayer = repository.findByLogin(login);
        ResponseStatus status = getAuthStatus(dbPlayer, password);
        ResponseEntity<Player> response;
        try {
            response = generateResponse(dbPlayer, status);
        } catch (Exception e) {
            response = new ResponseEntity<>(null, "Internal error", ResponseStatus.INTERNAL_ERROR);
        }

        return response;
    }

    public ResponseEntity<Player> changePlayerData(String email, String oldPassword, String newPassword,
                                                   String fullName, String login) {
        Player dbPlayer = repository.findByLogin(login);
        ResponseEntity<Player> response;
        try {
            if (dbPlayer == null) {
                response = generateResponse(null, ResponseStatus.ACCOUNT_NOT_FOUND);
            } else if (!dbPlayer.getPassword().equals(oldPassword)) {
                response = generateResponse(dbPlayer, ResponseStatus.INVALID_PASSWORD);
            } else if (!isEmailVacant(email, login)) {
                response = generateResponse(dbPlayer, ResponseStatus.EMAIL_NOT_VACANT);
            } else {
                dbPlayer.setEmail(email);
                dbPlayer.setPassword(newPassword);
                dbPlayer.setFullName(fullName);
                Player savedPlayer = repository.save(dbPlayer);
                response = generateResponse(savedPlayer, ResponseStatus.DATA_SUCCESSFULLY_CHANGED);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(null, "Internal error", ResponseStatus.INTERNAL_ERROR);
        }

        return response;
    }

    private boolean isEmailVacant(String email, String login) {
        Player byEmail = repository.findByEmail(email);
        return byEmail == null || byEmail.getLogin().equals(login);
    }

    private ResponseStatus getAuthStatus(Player playerData, String password) {
        ResponseStatus status;
        if (playerData == null) {
            status = ResponseStatus.ACCOUNT_NOT_FOUND;
        } else if (!playerData.getPassword().equals(password)) {
            status = ResponseStatus.INVALID_PASSWORD;
        } else {
            status = ResponseStatus.AUTHENTICATED_SUCCESSFULLY;
        }

        return status;
    }

    //TODO move message creating to enum
    private ResponseEntity<Player> generateResponse(Player data, ResponseStatus status) throws IllegalStatusException {
        String message;
        switch (status) {
            case ACCOUNT_CREATED: {
                message = "Аккаунт успешно создан";
                break;
            }
            case AUTHENTICATED_SUCCESSFULLY: {
                message = "Пользователь авторизован успешно";
                break;
            }
            case EMAIL_NOT_VACANT: {
                message = "Такая почта уже занята";
                break;
            }
            case LOGIN_NOT_VACANT: {
                message = "Такой логин уже занят";
                break;
            }
            case INVALID_PASSWORD: {
                message = "Неверный пароль";
                break;
            }
            case ACCOUNT_NOT_FOUND: {
                message = "Аккаунт с такими данными не найден";
                break;
            }
            case INTERNAL_ERROR: {
                message = "Внутренняя ошибка сервера";
                break;
            }
            case PASSWORD_MISS_MATCH: {
                message = "Пароли не совпадают";
                break;
            }
            case DATA_SUCCESSFULLY_CHANGED: {
                message = "Данные успешно изменены";
                break;
            }
            default: {
                log.error("Illegal stats={}", status);
                throw new IllegalStatusException();
            }
        }

        return new ResponseEntity<>(data, message, status);
    }
}
