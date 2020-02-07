package io.ficoscore.client.api;

import io.ficoscore.client.ApiException;
import io.ficoscore.client.ApiClient;
import io.ficoscore.client.model.*;
import io.ficoscore.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class ApiTest {

	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());

    private final FicoscoreApi api = new FicoscoreApi();
    private final SignerInterceptor interceptor = new SignerInterceptor();
	private ApiClient apiClient = null;

	@Before()
	public void setUp() {
		
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
    	OkHttpClient insecureClient = ApiClient.getClientNoSSLVerification();
    	OkHttpClient okHttpClient = insecureClient.newBuilder()
    			.readTimeout(60, TimeUnit.SECONDS)
    			.addInterceptor(interceptor)
    			.build();
    	apiClient.setHttpClient(okHttpClient);
	}

    @Test
    public void getReporteTest() throws ApiException {
		String xApiKey = "your_api_key";
		String username = "your_username";
		String password = "your_password";

        Peticion peticion = new Peticion();

		peticion.setFolio("XXXXXX");

		Persona persona = new Persona();
		persona.setNombres("XXXXXX");
		persona.setApellidoPaterno("XXXXXX");
		persona.setApellidoMaterno("XXXXXXXX");
		persona.setFechaNacimiento("DD-MM-YYYY");
		persona.setRFC("XXXXXXXXXXX");

		Domicilio domicilio = new Domicilio();
		domicilio.setDireccion("XXXXXXXX");
		domicilio.setColoniaPoblacion("XXXXXX");
		domicilio.setCiudad("XXXXX");
		domicilio.setCP("XXXXX");
		domicilio.setDelegacionMunicipio("XXXXXXX");
		domicilio.setEstado(CatalogoEstados.CDMX);

		persona.setDomicilio(domicilio);

		peticion.setPersona(persona);

        
		try {
	        Respuesta response = api.ficoscore(xApiKey, username, password, peticion);

	        Assert.assertTrue(response != null);
	        if(response != null) {
	        	logger.info(response.toString());
	        }
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
    }
    
}