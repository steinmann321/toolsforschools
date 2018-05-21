package de.toolsforschools.eventplanner.services;

import de.toolsforschools.eventplanner.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
