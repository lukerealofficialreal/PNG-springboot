package com.game.PNG;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.*;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.core.DefaultOAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Collections;
import java.util.Map;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

public class GitHubTokenIntrospector implements OpaqueTokenIntrospector {

    //private final WebClient webClient;
    private static final String userInfoUri = "https://api.github.com/user";

    public GitHubTokenIntrospector() {}

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {

        //Build the request to exchange the code for a token
        RestTemplate restTemplate = new RestTemplate();

		//make header for request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(listOf(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(token);

		//build request
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(userInfoUri);


		//wrap headers in entity
		HttpEntity<?> entity = new HttpEntity<>(headers);

		//return the response to the request
        Map<String, Object> userAttributes = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				Map.class).getBody();

        if (userAttributes == null || !userAttributes.containsKey("id")) {
            throw new OAuth2AuthenticationException("invalid token");
        }
        return new DefaultOAuth2AuthenticatedPrincipal(
                userAttributes,
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}