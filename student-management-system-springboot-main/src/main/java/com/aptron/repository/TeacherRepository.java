package com.aptron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aptron.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
