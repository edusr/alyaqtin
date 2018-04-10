package trup.de.maluco.alyaqtin.domain;

public class EurekaClientConfig {

	private boolean enable;
	private String serviceUrl;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	@Override
	public String toString() {
		return "EurekaClientConfig [enable=" + enable + ", serviceUrl=" + serviceUrl + "]";
	}
	
	

}
