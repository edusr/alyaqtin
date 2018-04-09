package trup.de.maluco.alyaqtin.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import trup.de.maluco.alyaqtin.domain.Route;
import trup.de.maluco.alyaqtin.services.ConfigService;

@RestController
public class ConfigRestController {
	
	@Autowired ConfigService configService;
	
	@PostMapping(name="addRoute/{nameRoute}")
	public void addRoute(@PathParam(value="nameRoute") String nameRoute,Route route) {
		configService.addZuulRoute(nameRoute, route);
	}

}
