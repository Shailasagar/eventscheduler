package io.github.Shailasagar.eventscheduler.service;

import io.github.Shailasagar.eventscheduler.exception.EventOverlapException;
import io.github.Shailasagar.eventscheduler.exception.UserNotFoundException;
import io.github.Shailasagar.eventscheduler.model.Event;
import io.github.Shailasagar.eventscheduler.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of EventService.
 */
@Service
public class EventServiceImpl implements io.github.Shailasagar.eventscheduler.service.EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        boolean isOverlap = eventRepository.existsByUserIdAndStartTime(event.getUser().getId(), event.getStartTime());
        if (isOverlap) {
            throw new EventOverlapException("User already has an event at this time.");
        }
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Event not found with ID: " + id));
    }

    @Override
    public List<Event> getEventsByUser(Long userId) {
        return eventRepository.findByUserId(userId);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
