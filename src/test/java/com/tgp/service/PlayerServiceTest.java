package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.repository.PlayerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        service = new PlayerService(repository);
    }

    @Test
    public void testAuthWithWrongLogin() {
        ResponseEntity<String> response = service.checkPlayerForAuth("wrong login", PASSWORD);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testAuthWithWrongPassword() {
        ResponseEntity<String> response = service.checkPlayerForAuth(LOGIN, "wrong password");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testAuthSuccess() {
        ResponseEntity<String> response = service.checkPlayerForAuth(LOGIN, PASSWORD);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}