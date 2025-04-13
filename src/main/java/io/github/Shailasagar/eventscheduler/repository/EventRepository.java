package io.github.Shailasagar.eventscheduler.repository;

import io.github.Shailasagar.eventscheduler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing Event entity.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * Find all events created by a specific user.
     * @param userId ID of the user
     * @return List of events
     */
    List<Event> findByUserId(Long userId);

    /**
     * Find events within a specific time range.
     * @param start Start time
     * @param end End time
     * @return List of events between those times
     */
    List<Event> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    /**
     * Check if the user has an event at the given time.
     * Used to prevent overlaps.
     * @param userId User ID
     * @param startTime Start time
     * @return true if overlapping event exists
     */
    boolean existsByUserIdAndStartTime(Long userId, LocalDateTime startTime);
}
