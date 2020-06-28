package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.keycloak.adapters.HttpClientBuilder;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://idoc.pttor.com/keycloak/auth/realms/pttor/.well-known/uma2-configuration");
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            String text = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        request = new HttpGet("https://test-idoc.pttor.com/keycloak/auth/realms/pttor/.well-known/uma2-configuration");
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            String text = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        HttpClient client = new HttpClientBuilder()
//                .establishConnectionTimeout(2000, TimeUnit.MILLISECONDS)
//                .socketTimeout(2000, TimeUnit.MILLISECONDS)
//                .build();
//
//        Map<String,Object> credentials = new HashMap<String,Object>();
//        credentials.put("secret", "");
//
//        String authServerUrl = "https://idoc.pttor.com/keycloak/auth";
//        String realm = "pttor";
//        String resource = "alfresco";
//        Configuration authzConfig = new Configuration(authServerUrl, realm, resource, credentials, client);
//        AuthzClient authzClient = AuthzClient.create(authzConfig);

        System.out.println( "Hello World!" );
    }
}
