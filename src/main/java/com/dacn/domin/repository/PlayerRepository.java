package com.dacn.domin.repository;

import com.dacn.domin.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {

    // Nếu tên bảng/cột trong database của bạn khác, chỉ cần sửa 3 câu SQL dưới đây
    // (và 3 tên cột trong PLAYER_MAPPER).
    private static final String SQL_TOP5_SHORTEST =
            "SELECT TOP 5 [Name], [Mode], [Time] FROM Player WHERE [Time] IS NOT NULL ORDER BY [Time] ASC";

    private static final String SQL_TOP5_LONGEST =
            "SELECT TOP 5 [Name], [Mode], [Time] FROM Player WHERE [Time] IS NOT NULL ORDER BY [Time] DESC";

    private static final String SQL_INSERT =
            "INSERT INTO Player ([Name], [Mode], [Time]) VALUES (?, ?, ?)";

    private static final RowMapper<Player> PLAYER_MAPPER = (rs, rowNum) -> new Player(
            rs.getString("Name"),
            rs.getString("Mode"),
            rs.getInt("Time"));

    private final JdbcTemplate jdbcTemplate;

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> findTop5Shortest() {
        return jdbcTemplate.query(SQL_TOP5_SHORTEST, PLAYER_MAPPER);
    }

    public List<Player> findTop5Longest() {
        return jdbcTemplate.query(SQL_TOP5_LONGEST, PLAYER_MAPPER);
    }

    public void insert(Player player) {
        jdbcTemplate.update(SQL_INSERT, player.name(), player.mode(), player.time());
    }
}
