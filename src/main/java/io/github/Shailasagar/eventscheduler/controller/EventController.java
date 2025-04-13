package io.github.Shailasagar.eventscheduler.controller;

import io.github.Shailasagar.eventscheduler.model.Event;
import io.github.Shailasagar.eventscheduler.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Event operations.
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Create a new event.
     */
    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        Event savedEvent = eventService.createEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    /**
     * Get event by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    /**
     * Get events for a user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> getEventsByUser(@PathVariable Long userId) {
        List<Event> events = eventService.getEventsByUser(userId);
        return ResponseEntity.ok(events);
    }

    /**
     * Delete event by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
