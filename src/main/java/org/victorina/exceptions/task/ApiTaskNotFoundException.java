package org.victorina.exceptions.task;

/**
 * Created by Danil Lyskin at 09:48 12.03.2021
 */
public class ApiTaskNotFoundException extends RuntimeException {

    public ApiTaskNotFoundException(final String mesaage) {
        super(mesaage);
    }
}
