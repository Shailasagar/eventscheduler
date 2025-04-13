package io.github.Shailasagar.eventscheduler.service;

import io.github.Shailasagar.eventscheduler.model.Event;

import java.util.List;

/**
 * Service interface for event-related operations.
 */
public interface EventService {

    Event createEvent(Event event);

    Event getEventById(Long id);

    List<Event> getEventsByUser(Long userId);

    void deleteEvent(Long id);
}
