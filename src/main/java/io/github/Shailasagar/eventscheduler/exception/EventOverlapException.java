package io.github.Shailasagar.eventscheduler.exception;

/**
 * Custom exception thrown when an event overlaps with an existing one.
 */
public class EventOverlapException extends RuntimeException {

    public EventOverlapException(String message) {
        super(message);
    }
}
