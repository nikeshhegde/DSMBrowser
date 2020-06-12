package com.service.DSMBrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootApplication
public class GitHubService {
	
	
	public static void getResponseFromGithubAPI() {
	    HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("https://api.github.com/repos/nikeshhegde/Simple-DevOps-Project/commits")
			  .header("accept", "application/json").queryString("since", "2019-08-16T22:16:53Z")
			  .queryString("until", "2020-04-20T22:16:53Z")
			  .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    
	    System.out.println("Response "+ jsonResponse.getBody().toString());
	    
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GitHubService.class, args);
		getResponseFromGithubAPI();
		
		
	}

}
