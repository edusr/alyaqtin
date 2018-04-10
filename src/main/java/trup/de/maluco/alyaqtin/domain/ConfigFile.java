package trup.de.maluco.alyaqtin.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConfigFile implements Serializable {

	private ZuulConfig zuul;
	private EurekaConfig eureka;

	public ZuulConfig getZuul() {
		return zuul;
	}

	public void setZuul(ZuulConfig zuul) {
		this.zuul = zuul;
	}

	public EurekaConfig getEureka() {
		return eureka;
	}

	public void setEureka(EurekaConfig eureka) {
		this.eureka = eureka;
	}

	@Override
	public String toString() {
		return "ConfigFile [zuul=" + zuul + ", eureka=" + eureka + "]";
	}
	
	

}
