package com.aptron;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aptron.entity.Admin;
import com.aptron.repository.AdminRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	@Value("${admin.username}")
	private String username;
	@Value("${admin.password}")
	private String password;
	@Autowired
	private AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Admin> optAdmin = adminRepository.findByUsernameAndPassword(username, password);
		if (!optAdmin.isPresent()) {
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			adminRepository.save(admin);
		}
	}

}
