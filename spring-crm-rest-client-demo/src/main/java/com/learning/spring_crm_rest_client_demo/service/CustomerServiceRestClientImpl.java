package com.learning.spring_crm_rest_client_demo.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Logger;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.spring_crm_rest_client_demo.dto.Customer;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {
	
	private RestTemplate restTemplate;
	
	private String crmRestUrl;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private String authUsername;
	private String authPassword;
	
	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${crm.rest.url}") String theUrl,
			@Value("${crm.rest.username}") String username,
			@Value("${crm.rest.password}") String password) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		authUsername = username;
		authPassword = password;
		
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
		System.out.println("Username for Auth is: "+authUsername);
	}
	
	private HttpHeaders createHeaders(String username, String password) {
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		String auth = username+":"+password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic "+new String(encodedAuth);
		
		httpHeaders.set("Authorization", authHeader);
		
		return httpHeaders;
	}
	
	private String getRequestJson(Customer theCustomer) {
	    ObjectMapper mapper = new ObjectMapper();
	    
	    String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(theCustomer);
		} catch (JsonProcessingException e) {
			logger.warning("Exception thrown while converting Customer Pojo to Json: "+e);
			e.printStackTrace();
		}
	    
	    return jsonString;
	}
	
	@Override
	public List<Customer> getCustomers() {
		
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);
		
		// make REST call
		//If its a Basic Get Request with no Authorization, then can be sent like below:
		
		//If it is a Get Request with Post Authorization then,
		//we can use one of the below two approaches:
		
		//Approach 1:
//		//Message Converter is not essentially Required:
////		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		restTemplate.getInterceptors().add(
//				new BasicAuthenticationInterceptor(authUsername, authPassword));
//		List<Customer> customers = restTemplate.getForObject(crmRestUrl, List.class);
		
		//Approach 2:
		ResponseEntity<List<Customer>> responseEntity = 
				restTemplate.exchange(crmRestUrl, HttpMethod.GET,
						new HttpEntity<String>(createHeaders(authUsername, authPassword)), 
						new ParameterizedTypeReference<List<Customer>>() {});
		
		// get the list of customers from response
		List<Customer> customers = responseEntity.getBody();
		
		logger.info("in getCustomers(): customers" + customers);
		
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {
		
		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);
		
		String getUrl = crmRestUrl.concat("/").concat(String.valueOf(theId));
		
		// make REST call
		//If its a Basic Get Request with no Authorization then can be sent like below:
//		Customer theCustomer = 
//				restTemplate.getForObject(getUrl, Customer.class);
		
		//But if its a Post Request with Authorization then,
		//we can use one of the below two approaches:
		
//		//Approach 1:
//		//Message Converter is not essentially Required:
////		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		restTemplate.getInterceptors().add(
//				new BasicAuthenticationInterceptor(authUsername, authPassword));
//		Customer theCustomer = restTemplate.getForObject(getUrl, Customer.class);
		
		//Approach 2:
		ResponseEntity<Customer> responseEntity = 
				restTemplate.exchange(getUrl, HttpMethod.GET,
						new HttpEntity<String>(createHeaders(authUsername, authPassword)), 
						new ParameterizedTypeReference<Customer>() {});
		
		Customer theCustomer = responseEntity.getBody();
		
		logger.info("in getCustomer(): theCustomer=" + theCustomer);
		
		return theCustomer;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		
		int employeeId = theCustomer.getId();
		
		// make REST call
		if (employeeId == 0) {
			logger.info("Adding new Customer");
			// add employee
			//If its a Basic Post Request with no Authorization, then can be sent like below:
//			restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);			
			
			//But if its a Post Request with Authorization then,
			//we can use one of the below two approaches:
			
			//Approach 1:
//			//Message Converter is not essentially Required: 
////			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//			restTemplate.getInterceptors().add(
//					new BasicAuthenticationInterceptor(authUsername, authPassword));
//			restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);

			//Approach 2:
			String requestJSon = getRequestJson(theCustomer);
			HttpHeaders httpHeaders = createHeaders(authUsername, authPassword);
			HttpEntity<String> httpEntity = new HttpEntity<String>(requestJSon, httpHeaders);
			
			restTemplate.exchange(crmRestUrl, HttpMethod.POST,
					httpEntity, new ParameterizedTypeReference<String>() {});
			
		} else {
			// update employee
			logger.info("Update existing Customer");
			
			//If its a Basic Put Request with no Authorization, then can be sent like below:
//			restTemplate.put(crmRestUrl, theCustomer);
			
			//But if its a Put Request with Authorization then,
			//we can use one of the below two approaches:
			
			//Approach 1:
//			//Message Converter is not essentially Required:
////			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//			restTemplate.getInterceptors().add(
//					new BasicAuthenticationInterceptor(authUsername, authPassword));
//			restTemplate.put(crmRestUrl, theCustomer);
			
			//Approach 2:
			String requestJSon = getRequestJson(theCustomer);
			HttpHeaders httpHeaders = createHeaders(authUsername, authPassword);
			HttpEntity<String> httpEntity = new HttpEntity<String>(requestJSon, httpHeaders);
			
			restTemplate.exchange(crmRestUrl, HttpMethod.PUT,
					httpEntity, new ParameterizedTypeReference<String>() {});
		}
		
		logger.info("in saveCustomer(): success");	
	}
	
	@Override
	public void deleteCustomer(int theId) {
		
		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);
		
		String deleteUrl = crmRestUrl.concat("/").concat(String.valueOf(theId));
		
		// make REST call
		//If its a Basic Put Request with no Authorization, then can be sent like below:
//		restTemplate.delete(deleteUrl);
		
		//But if its a Put Request with Authorization then,
		//we can use one of the below two approaches:
		
		//Approach 1:
//		//Message Converter is not essentially Required:
////		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		restTemplate.getInterceptors().add(
//				new BasicAuthenticationInterceptor(authUsername, authPassword));
//		restTemplate.delete(deleteUrl);
		
		//Approach 2:
		restTemplate.exchange(deleteUrl, HttpMethod.DELETE,
				new HttpEntity<String>(createHeaders(authUsername, authPassword)),
				new ParameterizedTypeReference<String>() {});
		
		logger.info("in deleteCustomer(): deleted customer theId=" + theId);
	}
	
}