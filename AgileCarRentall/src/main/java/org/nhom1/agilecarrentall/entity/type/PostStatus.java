package org.nhom1.agilecarrentall.entity.type;

import lombok.Getter;

@Getter
public enum PostStatus {
    PUBLISH("Publish"),
    DRAFT("Draft"),
    TRASH("Trash"),;

    private final String status;

    PostStatus(String status) {
        this.status = status;
    }

    public String getStatusClass() {
        return switch (this) {
            case PUBLISH -> "success";
            case DRAFT -> "secondary";
            case TRASH -> "danger";

        };
    }
}
