package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Lớp truy cập dữ liệu cho bảng Player trong database API_DACN_DOMIN.
 * <p>
 * Nếu tên bảng/cột thực tế trong SQL Server của bạn khác (ví dụ chữ thường,
 * hoặc "PlayerName" thay vì "Name"), chỉ cần sửa 3 câu SQL bên dưới và
 * phần map tên cột trong {@code PLAYER_ROW_MAPPER}.
 * </p>
 */
@Repository
public class PlayerRepository {

    private static final String SQL_TOP5_SHORTEST_TIME =
            "SELECT TOP 5 [Name], [Mode], [Time] " +
            "FROM Player " +
            "WHERE [Time] IS NOT NULL " +
            "ORDER BY [Time] ASC";

    private static final String SQL_TOP5_LONGEST_TIME =
            "SELECT TOP 5 [Name], [Mode], [Time] " +
            "FROM Player " +
            "WHERE [Time] IS NOT NULL " +
            "ORDER BY [Time] DESC";

    private static final String SQL_INSERT_PLAYER =
            "INSERT INTO Player ([Name], [Mode], [Time]) VALUES (?, ?, ?)";

    private static final RowMapper<Player> PLAYER_ROW_MAPPER = (rs, rowNum) -> new Player(
            rs.getString("Name"),
            rs.getString("Mode"),
            rs.getInt("Time")
    );

    private final JdbcTemplate jdbcTemplate;

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /** Top 5 người chơi có time ngắn nhất (nhanh nhất). */
    public List<Player> findTop5ByShortestTime() {
        return jdbcTemplate.query(SQL_TOP5_SHORTEST_TIME, PLAYER_ROW_MAPPER);
    }

    /** Top 5 người chơi có time dài nhất (lâu nhất). */
    public List<Player> findTop5ByLongestTime() {
        return jdbcTemplate.query(SQL_TOP5_LONGEST_TIME, PLAYER_ROW_MAPPER);
    }

    /** Thêm một người chơi mới vào bảng Player. */
    public void save(Player player) {
        jdbcTemplate.update(SQL_INSERT_PLAYER, player.name(), player.mode(), player.time());
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 10
    public List<Player> findTop5ByShortestTimeMode10() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '10' "
                + "ORDER BY [Time] ASC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 10
    public List<Player> findTop5ByLongestTimeMode10() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '10' "
                + "ORDER BY [Time] DESC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 16
    public List<Player> findTop5ByShortestTimeMode16() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '16' "
                + "ORDER BY [Time] ASC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 16
    public List<Player> findTop5ByLongestTimeMode16() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '16' "
                + "ORDER BY [Time] DESC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);  
    }

    //lấy top5 người chơi có thời gian ngắn nhất chế độ 30
    public List<Player> findTop5ByShortestTimeMode30() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '30' "
                + "ORDER BY [Time] ASC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);  
    }

    //lấy top5 người chơi có thời gian dài nhất chế độ 30
    public List<Player> findTop5ByLongestTimeMode30() {
        String sql = "SELECT TOP 5 [Name], [Mode], [Time] "
                + "FROM Player "
                + "WHERE [Time] IS NOT NULL AND [Mode] = '30' "
                + "ORDER BY [Time] DESC";
        return jdbcTemplate.query(sql, PLAYER_ROW_MAPPER);
    }
}
