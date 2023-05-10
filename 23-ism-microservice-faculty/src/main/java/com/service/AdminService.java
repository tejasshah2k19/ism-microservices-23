package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vo.UserVo;

@Service
public class AdminService {

	@Autowired
	RestTemplate restTemplate;

	public List<UserVo> getAllUsers() {

		ResponseEntity<UserVo[]> resp = restTemplate.getForEntity("http://ADMIN-SERVICE/getallusers", UserVo[].class);
		List<UserVo> users = Arrays.asList(resp.getBody());

		return users;
	}

	public List<UserVo> getAllUsers2() {
		ResponseEntity<List<UserVo>> response = restTemplate.exchange("http://ADMIN-SERVICE/getallusers",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<UserVo>>() {
				});
		List<UserVo> list = response.getBody();
		return list;
	}
}
