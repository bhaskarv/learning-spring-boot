package org.nvision.content_calendar;

import org.nvision.content_calendar.config.ContentCalendarProperties;
import org.nvision.content_calendar.model.Content;
import org.nvision.content_calendar.model.Status;
import org.nvision.content_calendar.model.Type;
import org.nvision.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> contentRepository.save(new Content(null, "Hello ChatGPT", "Hello ChatGPT",
                Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), null, "hello://chat.gpt"));
	}
}
