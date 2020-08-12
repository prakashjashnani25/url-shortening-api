package com.prakash.docker.urlshortening.service;

import org.springframework.stereotype.Service;

@Service
public class GenerateUUIDService {

	public Long getUniqueBase10Number() {
		return System.currentTimeMillis();
	}
}
