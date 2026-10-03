package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API cho bảng Player (database API_DACN_DOMIN).
 *
 * <ul>
 *   <li>GET  /api/players/top5/shortest-time → top 5 time ngắn nhất</li>
 *   <li>GET  /api/players/top5/longest-time  → top 5 time dài nhất</li>
 *   <li>POST /api/players                    → tạo người chơi mới</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/top5/shortest-time")
    public List<Player> getTop5ShortestTime() {
        return playerRepository.findTop5ByShortestTime();
    }

    @GetMapping("/top5/longest-time")
    public List<Player> getTop5LongestTime() {
        return playerRepository.findTop5ByLongestTime();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@Valid @RequestBody Player player) {
        playerRepository.save(player);
        return player;
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 10
    @GetMapping ("/top5/shortest-time/mode10")
    public List<Player> getTop5ShortestTimeMode10() {
        return playerRepository.findTop5ByShortestTimeMode10();
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 10
    @GetMapping ("/top5/longest-time/mode10")
    public List<Player> getTop5LongestTimeMode10() {
        return playerRepository.findTop5ByLongestTimeMode10();
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 16
    @GetMapping ("/top5/shortest-time/mode16")
    public List<Player> getTop5ShortestTimeMode16() {
        return playerRepository.findTop5ByShortestTimeMode16();
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 16
    @GetMapping ("/top5/longest-time/mode16")
    public List<Player> getTop5LongestTimeMode16() {
        return playerRepository.findTop5ByLongestTimeMode16();
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 30
    @GetMapping ("/top5/shortest-time/mode30")
    public List<Player> getTop5ShortestTimeMode30() {
        return playerRepository.findTop5ByShortestTimeMode30();
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 30
    @GetMapping ("/top5/longest-time/mode30")
    public List<Player> getTop5LongestTimeMode30() {
        return playerRepository.findTop5ByLongestTimeMode30();
    }
}
