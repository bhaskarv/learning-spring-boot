package org.nvision.content_calendar.repository;

import org.nvision.content_calendar.model.Content;
import org.nvision.content_calendar.model.Status;
import org.nvision.content_calendar.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";
        List<Content> content = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return  content;
    }

    private static Content mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Content(resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("desc"),
                Status.valueOf(resultSet.getString("status")),
                Type.valueOf(resultSet.getString("type")),
                LocalDateTime.now(), LocalDateTime.now(),
                resultSet.getString("url")
        );
    }
}
