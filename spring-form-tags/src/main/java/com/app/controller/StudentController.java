package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showform")
    public String showForm(Model model) {
        // Create a new Student object and add it as a model attribute
    	Student s =new Student();
        model.addAttribute("student", s);
        return "student-form"; // This should match the name of the JSP file
    }
        
    @RequestMapping("/details")
    public String showStudentDetails(@ModelAttribute("student") Student theStudent) {
   	System.out.println(theStudent);
   	return "student-details";
   }  
    }