package trup.de.maluco.alyaqtin.domain;

import java.util.Map;

public class ZuulConfig {

	private Map<String, Route> routes;

	public Map<String, Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Map<String, Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "ZuulConfig [routes=" + routes + "]";
	}
	
	

}
