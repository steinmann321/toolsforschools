package de.toolsforschools.eventplanner.repositories;

import de.toolsforschools.eventplanner.models.Todolist;
import de.toolsforschools.eventplanner.models.TodolistItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodolistItemRepository extends CrudRepository<TodolistItem, Long> {
}

