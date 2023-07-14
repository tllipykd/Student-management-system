package com.aptron.service;

import java.util.List;

import com.aptron.entity.Student;
import com.aptron.entity.Teacher;

public interface TeacherService {
	List<Teacher> getAllTeachers();

	Teacher saveTeacher(Teacher teacher);

	Teacher getTeacherById(Long id);

	Teacher updateTeacher(Teacher student);

	void deleteTeacherById(Long id);
}
