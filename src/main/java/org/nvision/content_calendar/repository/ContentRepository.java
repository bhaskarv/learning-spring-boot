package org.nvision.content_calendar.repository;

import org.nvision.content_calendar.model.Content;
import org.nvision.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM CONTENT
            WHERE status = :st
            """)
    List<Content> findByStatus(@Param("st") Status status);
}
