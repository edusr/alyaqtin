package trup.de.maluco.alyaqtin.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import trup.de.maluco.alyaqtin.domain.ConfigFile;
import trup.de.maluco.alyaqtin.domain.Route;
import trup.de.maluco.alyaqtin.domain.gitlab.GitlabFile;
import trup.de.maluco.alyaqtin.services.ConfigService;

@RestController
public class ConfigRestController {
	
	@Autowired ConfigService configService;
	
	@PostMapping(name="addRoute/{nameRoute}")
	public void addRoute(@PathParam(value="nameRoute") String nameRoute,Route route) {
		configService.addZuulRoute(nameRoute, route);
	}
	
	@GetMapping(name="teste")
	public void teste() {
		String url = "http://gitlab.com/gitlab/api/v4/projects/26/repository/files/application.yml?ref=master";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("ref", "master");
		
		String result = restTemplate.getForObject(url, String.class);
		
		ObjectMapper a = new ObjectMapper();
		
		try {
			GitlabFile gitlabFile = a.readValue(result, GitlabFile.class);
			
			
			String configFileDecoded = new String (Base64.decodeBase64(gitlabFile.getContent()));
			
			System.out.println(configFileDecoded);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		HttpHeaders headers = new HttpHeaders();
//		//headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//		
//		HttpEntity<GitlabFile> result = restTemplate.exchange(url, HttpMethod.GET,entity,GitlabFile.class);
		
		
		
		
		
	}

}
