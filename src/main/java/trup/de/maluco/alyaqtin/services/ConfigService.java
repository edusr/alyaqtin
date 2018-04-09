package trup.de.maluco.alyaqtin.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import trup.de.maluco.alyaqtin.domain.ConfigFile;
import trup.de.maluco.alyaqtin.domain.EurekaClientConfig;
import trup.de.maluco.alyaqtin.domain.EurekaConfig;
import trup.de.maluco.alyaqtin.domain.Route;
import trup.de.maluco.alyaqtin.domain.ZuulConfig;

@Service
public class ConfigService {

	public void addZuulRoute(String nameRoute, Route route) {

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.setSerializationInclusion(Include.NON_NULL);

		try {

			ConfigFile configFile = new ConfigFile();
			ZuulConfig zuulConfig = new ZuulConfig();
			
			EurekaConfig eurekaConfig = new EurekaConfig();
			EurekaClientConfig eurekaClientConfig = new EurekaClientConfig();

			eurekaClientConfig.setEnable(false);

			eurekaConfig.setClient(eurekaClientConfig);

//			route.setPath("/cadastro/**");
//			route.setUrl("http://stst.peixoto.com.br:28080/cadastro/pxt-rest/cadastroRestService");
//			route.setSensitive_headers("Cookie,Set-Cookie");

			configFile.setZuul(zuulConfig);
			configFile.setEureka(eurekaConfig);
			
			
			if(!configFile.getZuul().getRoutes().containsKey(nameRoute)){
				configFile.getZuul().getRoutes().put(nameRoute, route);
			}

			// Write object as YAML string
			String yaml = mapper.writeValueAsString(configFile).replaceAll("\"", "");

			System.out.println(yaml);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
