package com.prakash.docker.urlshortening.service;

import org.springframework.stereotype.Service;

@Service
public class ShortUrlGenrator {
	
	
	private static final char[] allowedChars;
	
	private static final Integer BASE=62;
	
	static{
		allowedChars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789".toCharArray();
		
	}
	
	public String encode(Long number) {
		// TODO Auto-generated method stub
		StringBuilder encodedString=new StringBuilder();
		
		if(number == 0)
			return allowedChars[0]+"";
		
		while(number>0) {
			encodedString.append(allowedChars[(int) (number%BASE)]);	
			number=number/BASE;
		}
		return encodedString.reverse().toString();
	}

	public int decode(String shortUrl) {
		int number=0;
		int power=0;
		for(int i=shortUrl.length()-1;i>=0;i--){
			number += shortUrl.charAt(i) * Math.pow(BASE, power++);
		}
		return number;
	}

	
}
