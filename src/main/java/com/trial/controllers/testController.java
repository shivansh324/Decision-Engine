package com.trial.controllers;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trial.models.UserModel;


@RestController
public class testController {
	
	@Autowired
	private KieSession session;
	
	@GetMapping("/trial")
	public String trial() {
		return "Hello Working";
	}
	
	@GetMapping("/progress-test")
	public UserModel testnow(@RequestBody UserModel user) {
		session.setGlobal("sucker", false);
		session.insert(user);
		session.getAgenda().getAgendaGroup("PROGRESS").setFocus();
		session.fireAllRules();
		return user;
	}
	
	@PostMapping("/user-progress")
	public UserModel progress(@RequestBody UserModel user) {
		session.insert(user);
		session.getAgenda().getAgendaGroup("USERPROGRESS").setFocus();
		session.fireAllRules();
		return user;
	}
}
