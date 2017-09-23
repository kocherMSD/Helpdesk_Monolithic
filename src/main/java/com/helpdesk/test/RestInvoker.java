 	 	package com.helpdesk.test;

 	 	import org.apache.commons.codec.binary.Base64;
 	 	import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
 	 	import org.springframework.boot.test.TestRestTemplate;
 	 	import org.springframework.core.ParameterizedTypeReference;
 	 	import org.springframework.http.HttpEntity;
 	 	import org.springframework.http.HttpHeaders;
 	 	import org.springframework.http.HttpMethod;
 	 	import org.springframework.http.ResponseEntity;
 	 	import org.springframework.util.MultiValueMap;
 	 	import org.springframework.web.client.RestTemplate;
 	 	import org.springframework.http.HttpStatus;
 	 	import org.springframework.http.ResponseEntity;

 	 	import java.net.URI;
 	 	import java.nio.charset.Charset;
public class RestInvoker {
 	 	    protected   EmbeddedWebApplicationContext server;

 	 	    protected static RestTemplate restTemplate = new TestRestTemplate();
 	 	    private static String baseUrl;

 	 	    public   RestInvoker(EmbeddedWebApplicationContext server) {
 	 	        this.server = server;
 	 	        baseUrl = "http://localhost:9080/helpdesk";
 	 	    }

 	 	    public static <T> ResponseEntity<T> get(String url, ParameterizedTypeReference<T> responseType) {
 	 	        HttpEntity<?> requestEntity = createAuthHeaders();
 	 	        return restTemplate.exchange(URI.create(baseUrl + url), HttpMethod.GET, requestEntity, responseType);
 	 	    }

 	 	    public static <T> ResponseEntity<T> get(String url, Class<T> responseType) {
 	 	        HttpEntity<?> requestEntity = createAuthHeaders();
 	 	        return restTemplate.exchange(URI.create("http://localhost:9080/helpdesk" + url), HttpMethod.GET, requestEntity, responseType);
 	 	    }

 	 	    private static HttpEntity<?> createAuthHeaders() {
 	 	        MultiValueMap<String, String> headers = createHeaders("arsinghcs", "rorkee246");
 	 	        return new HttpEntity<>(headers);
 	 	    }

 	 	    private static HttpHeaders createHeaders(String username, String password) {
 	 	        String auth = username + ":" + password;
 	 	        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
 	 	        String authHeader = "Basic " + new String(encodedAuth);
 	 	        HttpHeaders headers = new HttpHeaders();
 	 	        headers.set("Authorization", authHeader);
 	 	        return headers;
 	 	    }
 	 	    
 	 	  public static void main(String[] arg) {
 	         ResponseEntity<String> entity = get("/find?term=hello", String.class);

 	         System.out.println(entity.getStatusCode());
 	       // System.out.println(entity.getHeaders().get("Location").get(0));
 	 }
 	 	    
 	 	  
 	 	}