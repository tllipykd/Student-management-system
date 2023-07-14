package com.aptron.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptron.entity.Admin;
import com.aptron.entity.Subscribe;
import com.aptron.repository.SubscribeRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
public class ApplicationController {
	@Autowired
	private SubscribeRepository subscribeRepository;

	@GetMapping("/")
	public String home1() {
		return "index";
	}

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/faq")
	public String faq() {
		return "faq";
	}

	@PostMapping("/subscribe")
	@ResponseBody
	public Map<String, Object> subscribe(@RequestParam String email) {
		Map<String, Object> returnMap = new HashMap<>();
		Optional<Subscribe> optSubs = subscribeRepository.findByEmail(email);
		if (optSubs.isPresent()) {
			returnMap.put("unsuccess", "subscribed !");
			return returnMap;
		}
		Subscribe sub = new Subscribe();
		sub.setEmail(email);
		subscribeRepository.save(sub);
		returnMap.put("success", "subscribed !");
		return returnMap;
	}
	
	
	@GetMapping("/subscribers")
	public String listStudents(Model model) {
		model.addAttribute("subscribers", subscribeRepository.findAll());
		return "subscribers";
	}
	
}
