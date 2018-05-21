package de.toolsforschools.eventplanner.controllers;

import de.toolsforschools.eventplanner.models.Grade;
import de.toolsforschools.eventplanner.repositories.SchoolRepository;
import de.toolsforschools.eventplanner.services.H2DBService;
import de.toolsforschools.eventplanner.services.SpringDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Max;
import java.util.List;

@Controller
public class IndexController {
	@Autowired
	private H2DBService dbService;

	@RequestMapping(value={"", "/", "/index"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Check upcomng events in our school");
		return mv;
	}

	@RequestMapping(value="/grades", method = RequestMethod.GET)
	public ModelAndView gradesList() {
		ModelAndView mv = new ModelAndView("fragments/grades :: grades-list");
		mv.addObject("grades", dbService.getGradeList());
		return mv;
	}

	@RequestMapping(value="/events", method = RequestMethod.GET)
	public ModelAndView eventsList() {
		ModelAndView mv = new ModelAndView("fragments/events :: events-list");
		mv.addObject("events", dbService.getEventList());
		return mv;
	}

	@RequestMapping(value="/todos/{eventId}", method = RequestMethod.GET)
	public ModelAndView todoList(@PathVariable Long eventId) {
		ModelAndView mv = new ModelAndView("fragments/todos :: todos-list");
		mv.addObject("todos", dbService.getTodoListByEventId(eventId));
		return mv;
	}
}
