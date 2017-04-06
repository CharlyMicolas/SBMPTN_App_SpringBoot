package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;

import com.example.service.CourseService;


@Controller
public class CourseController {
	
	@Autowired
    CourseService courseDAO;
	
	 @RequestMapping("/course/view/{idCourse}")
	 public String viewPath (Model model, @PathVariable(value = "idCourse") String idCourse)
	    {
	        CourseModel course = courseDAO.selectCourse (idCourse);

	        if (course != null) {
	            model.addAttribute ("course", course);
	            return "viewCourse";
	        } else {
	            model.addAttribute ("idCourse", idCourse);
	            return "not-foundCourse";
	        }
	    }
}
