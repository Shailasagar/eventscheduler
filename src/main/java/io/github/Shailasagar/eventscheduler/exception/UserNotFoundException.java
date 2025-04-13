package io.github.Shailasagar.eventscheduler.exception;

/**
 * Custom exception thrown when a user is not found.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
