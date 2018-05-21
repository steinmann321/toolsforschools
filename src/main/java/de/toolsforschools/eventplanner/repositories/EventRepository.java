package de.toolsforschools.eventplanner.repositories;

import de.toolsforschools.eventplanner.models.Event;
import de.toolsforschools.eventplanner.models.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}

