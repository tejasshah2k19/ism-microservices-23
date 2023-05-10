package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@RequestMapping("/admin")
@RestController
@Slf4j
public class UserController {

	@Autowired
	UserRepository userRepo;

	@PostMapping("/addstudent")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {

		userRepo.save(user);
		log.info("AdminService::addstudent");
		return ResponseEntity.ok(user);
	}

	@GetMapping("/getallusers")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		log.info("AdminService::getallstudents");
		return ResponseEntity.ok(userRepo.findAll());
	}

}
