package de.toolsforschools.eventplanner.services;

import de.toolsforschools.eventplanner.models.*;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

@Service
@Transactional
public class H2DBService extends SpringDBService{
	/*
	some constants for dummy data;
	 */
	private static final String SUMMER_EVENT_NAME = "Sommermarkt";
	private static final String WINTER_EVENT_NAME = "Winterfest";
	private static String[] TODO_LIST_ITEMS = {"Kuchen","Salat","Aufbauen","Abbauen"};
	/**
	 * this will set up some dummy data to start with
	 */
	public void initDefaultData() {
		School s = new School();
		s.setName("Rudolf-Steiner-Schule");
		schoolRepository.save(s);

		List<Event> eventList = new ArrayList<>();
		try {
			eventList.add(new Event(SUMMER_EVENT_NAME, "26.06.2018"));
			eventList.add(new Event(WINTER_EVENT_NAME, "17.11.2018"));
			eventRepository.saveAll(eventList);
		}catch (ParseException e) {
			e.printStackTrace();
		}

		schoolRepository.findAll().forEach(school -> {
			List<Grade> gradeList = new ArrayList<>();
			List<Todolist> todoList = new ArrayList<>();
			for (int i = 1; i < 7; i++) {
				// add a grade
				Grade g = new Grade();
				g.setName(String.format("Klasse %d", i));
				g.setTeacherName(RandomStringUtils.randomAlphabetic(10));
				g.setSchool(school);
				gradeList.add(g);
				// add todolist to grade and event
				eventRepository.findAll().forEach(evt -> {
					Todolist t = new Todolist();
					t.setName(String.format("ToDo-Liste %s", evt.getName()));
					t.setEvent(evt);
					t.setGrade(g);
					todoList.add(t);
				});
			}
			gradeRepository.saveAll(gradeList);
			todolistRepository.saveAll(todoList);
		});

		Random rand = new Random();
		todolistRepository.findAll().forEach(todoList -> {
			List<TodolistItem> todoListItemList = new ArrayList<>();
			for(String todoListItemName: TODO_LIST_ITEMS) {
				if(rand.nextInt(10) % 2 == 0) {
					continue;
				}
				TodolistItem todoListItem = new TodolistItem();
				todoListItem.setName(todoListItemName);
				todoListItem.setTodolist(todoList);
				todoListItemList.add(todoListItem);
			}
			todolistItemRepository.saveAll(todoListItemList);
		});

		System.out.println("Dummy data ready");
		System.out.println("------------- schools ------------");
		schoolRepository.findAll().forEach(System.out::println);
		System.out.println("------------- grades ------------");
		gradeRepository.findAll().forEach(System.out::println);
		System.out.println("------------- events ------------");
		eventRepository.findAll().forEach(System.out::println);
		System.out.println("------------- todolists ------------");
		todolistRepository.findAll().forEach(System.out::println);
		System.out.println("------------- todolist items ------------");
		todolistItemRepository.findAll().forEach(System.out::println);
	}
}
