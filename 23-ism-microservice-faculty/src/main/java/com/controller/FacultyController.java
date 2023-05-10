package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FacultyController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUsers(){
		log.info("FacultyController::getallusers");
		return ResponseEntity.ok(adminService.getAllUsers());
	}
	
	@GetMapping("/getallusers2")
	public ResponseEntity<?> getAllUsers2(){
		log.info("FacultyController::getallusers2");
		return ResponseEntity.ok(adminService.getAllUsers2());
	}
	
}
