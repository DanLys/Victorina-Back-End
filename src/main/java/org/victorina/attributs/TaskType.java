package org.victorina.attributs;

import org.victorina.exceptions.task.TaskTypeNotFound;

/**
 * Created by Danil Lyskin at 23:00 12.02.2021
 */
public enum TaskType {

    TEXT(0L, "Text"),
    IMAGE(1L, "Image");

    TaskType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public static TaskType of(String str) {
        for (TaskType value : values()) {
            if (value.getType().toLowerCase().equals(str.toLowerCase())) {
                return value;
            }
        }
        throw new TaskTypeNotFound("Task type: " + str + " doesn`t exist");
    }

    private final Long id;
    private final String type;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
