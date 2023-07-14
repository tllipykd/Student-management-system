package com.aptron.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptron.entity.Admin;
import com.aptron.repository.AdminRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

	@Autowired
	AdminRepository adminRepository;

	@PostMapping("/check_password")
	@ResponseBody
	public Map<String, Object> adminCheck(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> returnMap = new HashMap<>();
		Optional<Admin> admin = adminRepository.findByUsernameAndPassword(username, password);
		if (admin.isPresent()) {
			returnMap.put("success", "Valid Admin");
		} else
			returnMap.put("success", "InValid Admin");
		return returnMap;
	}
	

}
