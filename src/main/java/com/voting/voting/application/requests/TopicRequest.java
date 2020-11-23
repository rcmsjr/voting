package com.voting.voting.application.requests;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class TopicRequest {

    @NotBlank(message = "Title cannot be blank")
    protected String title;

    @NotBlank(message = "Description cannot be blank")
    protected String description;

    @FutureOrPresent(message = "EndAt cannot be in the past.")
    protected Date endAt;

    public TopicRequest() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndAt() {
        return this.endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }
}
