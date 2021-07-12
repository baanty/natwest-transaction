package com.natwest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Use this class to load the Spring boot context.
 * @author Pijush Kanti Das
 *
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NatwestTransactionApi {

	public static void main(String[] args) {
		SpringApplication.run(NatwestTransactionApi.class, args);
	}
}
