package de.toolsforschools.eventplanner.repositories;

import de.toolsforschools.eventplanner.models.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {
}

