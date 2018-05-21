package de.toolsforschools.eventplanner.services;

import de.toolsforschools.eventplanner.models.Event;
import de.toolsforschools.eventplanner.models.Grade;
import de.toolsforschools.eventplanner.models.Todolist;

import java.util.List;

public interface IDBService {
	List<Grade> getGradeList();
	List<Event> getEventList();
	List<Todolist> getTodoListByEventAndGrade(Event event, Grade grade);
	List<Todolist> getTodoListByEventIdAndGradeId(Long eventId, Long gradeId);
}
