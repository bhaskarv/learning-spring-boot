package org.nvision.content_calendar.repository;

import jakarta.annotation.PostConstruct;
import org.nvision.content_calendar.model.Content;
import org.nvision.content_calendar.model.Status;
import org.nvision.content_calendar.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCreationRepository {
    private final List<Content> contentList = new ArrayList<>();

    private final Logger logger = LoggerFactory.getLogger(ContentCreationRepository.class);
    public ContentCreationRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content content1 = new Content(1, "First Blog Post", "My First Blog Post",
                Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), null, "");
        contentList.add(content1);
    }

    public void save(Content content) {
        contentList.removeIf( c -> c.id().equals(content.id()));
        contentList.add(content);
    }


    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
