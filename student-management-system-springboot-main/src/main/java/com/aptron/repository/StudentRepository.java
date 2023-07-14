package com.aptron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aptron.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
