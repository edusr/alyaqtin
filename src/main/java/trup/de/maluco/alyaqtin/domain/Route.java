package trup.de.maluco.alyaqtin.domain;

public class Route {

	private String path;
	private String url;
	private String sensitive_headers;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSensitive_headers() {
		return sensitive_headers;
	}

	public void setSensitive_headers(String sensitive_headers) {
		this.sensitive_headers = sensitive_headers;
	}

	@Override
	public String toString() {
		return "Route [path=" + path + ", url=" + url + ", sensitive_headers=" + sensitive_headers + "]";
	}
	
	

}
