package com.prakash.docker.urlshortening.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.prakash.docker.urlshortening.dto.UrlShortRequest;

@Service
public class InMemoryRepository {

	private ConcurrentHashMap<String, UrlShortRequest> urlShortMap=new ConcurrentHashMap<>();

	public UrlShortRequest getOrigRequest(String shortUrl) {
		return urlShortMap.get(shortUrl);
	}

	public String save(UrlShortRequest request) {
		urlShortMap.put(request.getShortUrl(),request);
		return getOrigRequest(request.getShortUrl()).getShortUrl();
	}
	
}
