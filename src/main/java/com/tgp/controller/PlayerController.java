package com.tgp.controller;

import com.tgp.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("player")
public class PlayerController {
    private int counter = 4;
    private List<Map<String, String>> players = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "Miracle"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Kuroky"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Gh"); }});
    }};

    @GetMapping
    public List<Map<String, String>> getPlayers() {
        return players;
    }

    @GetMapping("{id}")
    public Map<String, String> getPlayer(@PathVariable String id) {
//TODO
    }

    private Map<String, String> getOne(@PathVariable String id) {
        return players.stream()
                .filter(val -> val.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);

    }

    @PostMapping
    public Map<String, String> createPlayer(@RequestBody Map<String, String> player) {
        player.put("id", String.valueOf(counter++));

        players.add(player);

        return player;
    }

    @PutMapping("{id}")
    public Map<String, String> updatePlayer(@RequestBody Map<String, String> player) {

    }

    @DeleteMapping("{id}")
    public Map<String, String> deletePlayer(@PathVariable String id) {
        Map<String, String> player = players.stream()
                .filter(val -> val.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        if (player != null) {

        }
    }
}
