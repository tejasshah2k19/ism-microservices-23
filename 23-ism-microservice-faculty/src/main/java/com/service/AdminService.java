package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vo.UserVo;

@Service
public class AdminService {

	public List<UserVo> getAllUsers() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<UserVo[]> resp = restTemplate.getForEntity("http://localhost:9999/getallusers", UserVo[].class);
		List<UserVo> users = Arrays.asList(resp.getBody());

		return users;
	}

	public List<UserVo> getAllUsers2() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UserVo>> response = restTemplate.exchange("http://localhost:9999/getallusers",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<UserVo>>() {
				});
		List<UserVo> list = response.getBody();
		return list;
	}
}
