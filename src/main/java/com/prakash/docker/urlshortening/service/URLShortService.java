package com.prakash.docker.urlshortening.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.docker.urlshortening.dto.UrlShortRequest;
import com.prakash.docker.urlshortening.repository.InMemoryRepository;

@Service
public class URLShortService {

	@Autowired
	private InMemoryRepository urlRepos;
		
	@Autowired
	private GenerateUUIDService uniqueSequenceGenerator;
	
	@Autowired
	private ShortUrlGenrator urlGenerator;
	
	
	public String createShortUrl(UrlShortRequest request) {
		int number = uniqueSequenceGenerator.getUniqueBase10Number();
		String shortUrl=urlGenerator.encode(number);
		request.setId(number);
		request.setShortUrl(shortUrl);
		return urlRepos.save(request);
	}

	public String getOrigUrl(String shortUrl) {
		urlGenerator.decode(shortUrl);
		return urlRepos.getOrigRequest(shortUrl).getLongUrl();
	}

}
