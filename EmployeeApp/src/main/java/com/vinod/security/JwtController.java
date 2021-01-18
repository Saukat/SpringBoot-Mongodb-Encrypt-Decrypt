package com.vinod.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinod.jwt.JwtTokenUtil;

@RestController
public class JwtController {
	
	@Autowired
	private UserDetailsService userService;
	@Autowired
	private JwtTokenUtil util;
	@Autowired 
	private AuthenticationManager manager;
	
	
	
      @PostMapping("/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest req) {
		String token=null;
		try {
		
		UserDetails userDetails = userService.loadUserByUsername(req.getUsername());
		manager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
		 token = util.generateToken(userDetails);
		
		}catch (DisabledException e) {
			e.printStackTrace();
			System.out.println("Account is Disabled");
		}catch(BadCredentialsException b) {
			b.printStackTrace();
			System.out.println("Bad Credentials");
		}catch(LockedException l) {
			l.printStackTrace();
			System.out.println("Account is Locked");
		}
			
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
