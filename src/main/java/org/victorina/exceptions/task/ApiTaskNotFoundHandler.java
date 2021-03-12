package org.victorina.exceptions.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Danil Lyskin at 09:49 12.03.2021
 */
@Slf4j
@ControllerAdvice
public class ApiTaskNotFoundHandler {

    @ExceptionHandler(value = {ApiTaskNotFoundException.class})
    public ResponseEntity<Object> handleNonexistentUser(ApiTaskNotFoundException e) {
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        log.error("Task not found: " + e.getMessage());
        return new ResponseEntity<>(apiException, notFound);
    }
}
