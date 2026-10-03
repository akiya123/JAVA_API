package com.dacn.domin.controller;

import com.dacn.domin.model.Player;
import com.dacn.domin.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /** Top 5 người chơi có time ngắn nhất. */
    @GetMapping("/top5/shortest")
    public List<Player> getTop5Shortest() {
        return playerRepository.findTop5Shortest();
    }

    /** Top 5 người chơi có time dài nhất. */
    @GetMapping("/top5/longest")
    public List<Player> getTop5Longest() {
        return playerRepository.findTop5Longest();
    }

    /** Tạo người chơi mới. */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@Valid @RequestBody Player player) {
        playerRepository.insert(player);
        return player;
    }
}
