package org.victorina.exceptions.task;

/**
 * Created by Danil Lyskin at 23:08 12.02.2021
 */
public class TaskTypeNotFound extends RuntimeException {

    public TaskTypeNotFound(final String message) {
        super(message);
    }
}
