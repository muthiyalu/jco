package org.jco.applications;

import org.jco.applications.auth.XsrfUtils;
import org.jco.applications.services.GoogleOauth2AuthService;
import org.jco.applications.services.Oauth2AuthService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JCOMsApplication {


	@Bean
	public Oauth2AuthService getOuth2Service() throws Exception {
		return new GoogleOauth2AuthService();
	}

	@Bean
	public XsrfUtils getsrfToken() throws Exception {
		return new XsrfUtils();
	}

	public static void main(String[] args) {

		SpringApplication.run(JCOMsApplication.class, args);
	}
}
