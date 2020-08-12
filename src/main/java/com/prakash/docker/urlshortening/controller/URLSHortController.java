package com.prakash.docker.urlshortening.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.docker.urlshortening.dto.UrlShortRequest;
import com.prakash.docker.urlshortening.service.URLShortService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class URLSHortController {

	private static final Logger LOG=LoggerFactory.getLogger(URLSHortController.class);
	
	@Autowired
	private URLShortService urlShorteningService;
	
	@ApiOperation(value="API End Point Use To Convert Input URL To Short URL (Base 62 , 7 Length)")
	@PostMapping(value="createShortUrl")
	public String urlToShort(@RequestBody UrlShortRequest request) {
		LOG.info("Request {}",request);
		return urlShorteningService.createShortUrl(request);
	}
	
	@ApiOperation(value="API End Point Use To Convert Input URL To Short URL (Base 62 , 7 Length)")
	@GetMapping(value="createShortUrl1")
	public String urlToShort1(@RequestParam("url") String request) {
		LOG.info("Request {}",request);
		UrlShortRequest req=new UrlShortRequest();
		req.setLongUrl(request);
		return urlShorteningService.createShortUrl(req);
	}
	
	@ApiOperation(value="API end Point Use To Get Orig Url")
	@GetMapping(value="./{shortUrl}/")
	public String getOrigUrl(@PathVariable String shortUrl) {
		return urlShorteningService.getOrigUrl(shortUrl);
	}
}
