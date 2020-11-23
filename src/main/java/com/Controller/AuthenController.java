package com.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenController {
	private static final Logger logger = LoggerFactory.getLogger(AuthenController.class);

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, Object> payload){
		logger.info("payload={}",payload );
		return ResponseEntity.ok(true);
	}

}
