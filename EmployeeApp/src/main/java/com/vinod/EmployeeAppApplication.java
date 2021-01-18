package com.vinod;


import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bol.crypt.CryptVault;
import com.bol.secure.CachedEncryptionEventListener;


@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}
	
	

	
	
	
	/*
	 * @Bean public MongoClientOptions mongoOptions() { return MongoClientOptions
	 * .builder() .maxConnectionIdleTime(60000) .build(); }
	 */
	/*
	 * @Bean public MongoDatabase getConnection() {
	 * 
	 * MongoClient mongoClient = MongoClients.create(
	 * "mongodb+srv://vinodwus:root@cluster0.iwkdr.mongodb.net/test?retryWrites=true&w=majority"
	 * ); MongoDatabase database = mongoClient.getDatabase("test");
	 * 
	 * return database; }
	 */


	

}
