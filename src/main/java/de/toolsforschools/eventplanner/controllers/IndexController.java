package de.toolsforschools.eventplanner.controllers;

import de.toolsforschools.eventplanner.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@Autowired
	private SchoolRepository schoolRepository;

	@RequestMapping(value={"", "/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "Check upcoming events in our school");
		model.addAttribute("schools", schoolRepository.findAll());
		return "index";
	}
}
