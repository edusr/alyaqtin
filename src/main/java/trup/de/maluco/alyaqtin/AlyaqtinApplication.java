package trup.de.maluco.alyaqtin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import trup.de.maluco.alyaqtin.domain.ConfigFile;
import trup.de.maluco.alyaqtin.domain.EurekaClientConfig;
import trup.de.maluco.alyaqtin.domain.EurekaConfig;
import trup.de.maluco.alyaqtin.domain.Route;
import trup.de.maluco.alyaqtin.domain.ZuulConfig;

@SpringBootApplication
public class AlyaqtinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlyaqtinApplication.class, args);

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.setSerializationInclusion(Include.NON_NULL);
		

		try {

			//ZuulConfig zuulConfig = mapper.readValue(new File("user.yaml"), ZuulConfig.class);
			
			ConfigFile configFile = new ConfigFile();
			ZuulConfig zuulConfig = new ZuulConfig() ;
			Route route = new Route();
			
			EurekaConfig eurekaConfig = new EurekaConfig();
			EurekaClientConfig eurekaClientConfig = new EurekaClientConfig();
			
			eurekaClientConfig.setEnable(false);
			
			eurekaConfig.setClient(eurekaClientConfig);
			
			route.setPath("/cadastro/**");
			route.setUrl("http://stst.peixoto.com.br:28080/cadastro/pxt-rest/cadastroRestService");
			route.setSensitive_headers("Cookie,Set-Cookie");
			
			configFile.setZuul(zuulConfig);
			configFile.setEureka(eurekaConfig);
			Map<String,Route> map = new HashMap<>();
			map.put("cadastro", route);
			zuulConfig.setRoutes(map);
			
			// Write object as YAML string
			String yaml = mapper.writeValueAsString(configFile).replaceAll("\"", "");
			
			System.out.println(yaml);

			//System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}
}
