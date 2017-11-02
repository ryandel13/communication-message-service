package net.mkengineering.studies.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommunicationServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationServiceAppApplication.class, args);
	}
}
