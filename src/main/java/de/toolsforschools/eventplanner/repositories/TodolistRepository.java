package de.toolsforschools.eventplanner.repositories;

import de.toolsforschools.eventplanner.models.Event;
import de.toolsforschools.eventplanner.models.Todolist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodolistRepository extends CrudRepository<Todolist, Long> {
	List<Todolist> findByEvent_IdAndGrade_Id(Long eventId, Long gradeId);
}

