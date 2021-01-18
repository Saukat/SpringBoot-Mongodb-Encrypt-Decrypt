package com.vinod.controller;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bol.crypt.CryptVault;
import com.bol.secure.CachedEncryptionEventListener;
import com.vinod.entity.Employee;
import com.vinod.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeRepository repo;
	
	/*
	 * private static final byte[] secretKey =
	 * Base64.getDecoder().decode("hqHKBLV83LpCqzKpf8OvutbCs+O5wX5BPu3btWpEvXA=");
	 * private static final byte[] oldKey =
	 * Base64.getDecoder().decode("cUzurmCcL+K252XDJhhWI/A/+wxYXLgIm678bwsE2QM=");
	 * 
	 * @Bean public CryptVault cryptVault() { return new CryptVault()
	 * .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(0, oldKey)
	 * .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(1, secretKey) // can be omitted
	 * if it's the highest version .withDefaultKeyVersion(1); }
	 * 
	 * @Bean public CachedEncryptionEventListener encryptionEventListener(CryptVault
	 * cryptVault) { return new CachedEncryptionEventListener(cryptVault); }
	 */
	
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return ResponseEntity.ok("HI this success page");
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Employee> addNewUsers(@RequestBody Employee emp) {
		LOG.info("Saving user.");
		return ResponseEntity.ok(repo.save(emp));
	}
	
	
	
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> fetchAllEmployee(@RequestBody Employee emp) {
		LOG.info("fetching user.");
		return ResponseEntity.ok(repo.findAll());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
