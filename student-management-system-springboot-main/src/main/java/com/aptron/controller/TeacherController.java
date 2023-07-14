package com.aptron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aptron.entity.Teacher;
import com.aptron.service.TeacherService;

@Controller
public class TeacherController {

	private TeacherService teacherService;


	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/teachers")
	public String listTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}

	@GetMapping("/teachers/new")
	public String createTeacherForm(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "create_teacher";

	}

	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		//  manage date 2023-05-15  YYYY-MM-DD  to DD-MM-YYYY
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}

	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable Long id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		return "edit_teacher";
	}

	@PostMapping("/teachers/{id}")
	public String updateTeachers(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher, Model model) {

		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setFirstName(teacher.getFirstName());
		existingTeacher.setLastName(teacher.getLastName());
		existingTeacher.setEmail(teacher.getEmail());
		existingTeacher.setMobile(teacher.getMobile());
		existingTeacher.setAddress(teacher.getAddress());
		existingTeacher.setDob(teacher.getDob());
		existingTeacher.setGender(teacher.getGender());
		existingTeacher.setQualification(teacher.getQualification());
		existingTeacher.setSalary(teacher.getSalary());
		existingTeacher.setSubject(teacher.getSubject());
		existingTeacher.setYearOfExp(teacher.getYearOfExp());

		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";
	}

	// handler method to handle delete student request

	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}
}
