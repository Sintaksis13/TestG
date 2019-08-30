package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.repository.PlayerRepository;
import com.tgp.service.response.ResponseEntity;
import com.tgp.service.response.ResponseStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FULL_NAME = "full name";
    private static final String EMAIL = "email@mail.com";

    @Mock
    private PlayerRepository repository;
    private PlayerService service;

    @Before
    public void setUp() {
        Player expectedPlayer = new Player(LOGIN, PASSWORD, FULL_NAME, EMAIL);
        when(repository.findByLogin(LOGIN)).thenReturn(expectedPlayer);
        when(repository.findByEmail(EMAIL)).thenReturn(expectedPlayer);
        service = new PlayerService(repository);
    }

    @Test
    public void testAuth_withWrongLogin() {
        ResponseEntity<Player> response = service.checkPlayerForAuth("wrong login", PASSWORD);
        assertEquals(ResponseStatus.ACCOUNT_NOT_FOUND, response.getStatus());
    }

    @Test
    public void testAuth_withWrongPassword() {
        ResponseEntity<Player> response = service.checkPlayerForAuth(LOGIN, "wrong password");
        assertEquals(ResponseStatus.INVALID_PASSWORD, response.getStatus());
    }

    @Test
    public void testAuth_success() {
        ResponseEntity<Player> response = service.checkPlayerForAuth(LOGIN, PASSWORD);
        assertEquals(ResponseStatus.AUTHENTICATED_SUCCESSFULLY, response.getStatus());
    }

    @Test
    public void testRegister_success() {
        ResponseEntity<Player> response = service.registerPlayer("new", "pass", "full", "email");
        assertEquals(ResponseStatus.ACCOUNT_CREATED, response.getStatus());
    }

    @Test
    public void testRegister_withExistedLogin() {
        ResponseEntity<Player> response = service.registerPlayer(LOGIN, "pass", "full", "email");
        assertEquals(ResponseStatus.LOGIN_NOT_VACANT, response.getStatus());
    }

    @Test
    public void testRegister_withExistedEmail() {
        ResponseEntity<Player> response = service.registerPlayer("new", "pass", "full", EMAIL);
        assertEquals(ResponseStatus.EMAIL_NOT_VACANT, response.getStatus());
    }
}