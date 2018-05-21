package de.toolsforschools.eventplanner.services;

import de.toolsforschools.eventplanner.models.Event;
import de.toolsforschools.eventplanner.models.Grade;
import de.toolsforschools.eventplanner.models.Todolist;
import de.toolsforschools.eventplanner.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringDBService implements IDBService {
	@Autowired
	protected SchoolRepository schoolRepository;
	@Autowired
	protected GradeRepository gradeRepository;
	@Autowired
	protected EventRepository eventRepository;
	@Autowired
	protected TodolistRepository todolistRepository;
	@Autowired
	protected TodolistItemRepository todolistItemRepository;

	@Override
	public List<Grade> getGradeList() {
		return (List<Grade>) gradeRepository.findAll();
	}

	@Override
	public List<Event> getEventList() {
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public List<Todolist> getTodoListByEvent(Event event) {
		return this.getTodoListByEventId(event.getId());
	}

	@Override
	public List<Todolist> getTodoListByEventId(Long eventId) {
		return todolistRepository.findByEvent_Id(eventId);
	}
}
