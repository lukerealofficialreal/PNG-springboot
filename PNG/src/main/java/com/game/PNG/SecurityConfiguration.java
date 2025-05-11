
package com.game.PNG;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.oauth2Login(Customizer.withDefaults())
				.authorizeHttpRequests((authz) -> authz
						.anyRequest().authenticated()
				).oauth2ResourceServer(oauth2 -> oauth2
						.opaqueToken(opaqueToken -> opaqueToken
								.introspector(githubIntrospector())
						)
				)
				.httpBasic(withDefaults());
		return http.build();
	}

	private OpaqueTokenIntrospector githubIntrospector() {
		return new GitHubTokenIntrospector();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/", "/login**", "/error","/FGG**");
	}

}
