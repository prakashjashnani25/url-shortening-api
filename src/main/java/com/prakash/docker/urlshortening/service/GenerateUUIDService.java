package com.prakash.docker.urlshortening.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class GenerateUUIDService {

	public Integer getUniqueBase10Number() {
		return UUID.randomUUID().clockSequence();
	}
}
