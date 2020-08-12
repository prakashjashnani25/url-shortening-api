package com.prakash.docker.urlshortening.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Prakash
 *
 */
@ApiModel(description="Request Object For URL Shortnening PI createShortUrl API")
public class UrlShortRequest {
	
	@ApiModelProperty(required=true,notes="Orignal Long Url")
	private String longUrl;
	
	@ApiModelProperty(notes="Optional Expiiration Time")
	private LocalDateTime expireDate;

	private Long id;
	
	private  String shortUrl;
	
	
	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public String toString() {
		return "UrlShortRequest [longUrl=" + longUrl + ", id=" + id + ", shortUrl=" + shortUrl + "]";
	}

	
	
}
