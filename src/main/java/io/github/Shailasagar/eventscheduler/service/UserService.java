package io.github.Shailasagar.eventscheduler.service;

import io.github.Shailasagar.eventscheduler.model.User;

import java.util.List;

/**
 * Service interface for user-related operations.
 */
public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
