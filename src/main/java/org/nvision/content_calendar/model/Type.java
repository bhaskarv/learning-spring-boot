package org.nvision.content_calendar.model;

public enum Type {
    ARTICLE("ARTICLE"),
    VIDEO("VIDEO"),
    COURSE("COURSE"),
    CONFERENCE_TALK("CONFERENCE_TALK");

    public String type;

    Type(String type) {
        this.type = type;
    }
}
