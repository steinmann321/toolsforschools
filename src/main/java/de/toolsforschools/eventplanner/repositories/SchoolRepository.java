package de.toolsforschools.eventplanner.repositories;

import de.toolsforschools.eventplanner.models.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
}

