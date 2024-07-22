package org.nvision.content_calendar.model;

public enum Status {
    IDEA("IDEA"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    PUBLISHED("PUBLISHED");

    public String status;
    Status(String status) {
        this.status = status;
    }

}
