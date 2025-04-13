package io.github.Shailasagar.eventscheduler.repository;

import io.github.Shailasagar.eventscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing User entity.
 * Provides CRUD operations and custom query methods.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Check if a user exists with the given email.
     * @param email Email to search
     * @return true if exists, false otherwise
     */
    boolean existsByEmail(String email);
}
