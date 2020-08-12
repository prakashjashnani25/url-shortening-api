package com.prakash.docker.urlshortening.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prakash.docker.urlshortening.dto.UrlShortRequest;

@Service
public class InMemoryRepository {

	private static final Logger LOG=LoggerFactory.getLogger(InMemoryRepository.class);
	
	private ConcurrentHashMap<String, UrlShortRequest> urlShortMap=new ConcurrentHashMap<>();

	public UrlShortRequest getOrigRequest(String shortUrl) {
		LOG.info(" Param {} ",shortUrl);
		LOG.debug("Cache Value {} ",urlShortMap);
		return urlShortMap.get(shortUrl);
	}

	public String save(UrlShortRequest request) {
		LOG.info(" Param {} ",request);
		LOG.debug("Cache Value {} ",urlShortMap);
		urlShortMap.put(request.getShortUrl(),request);
		return getOrigRequest(request.getShortUrl()).getShortUrl();
	}
	
}
