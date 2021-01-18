package com.vinod.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vinod.jwt.JwtTokenUtil;
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtTokenUtil util;
	@Autowired 
	private UserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header  = request.getHeader("Authorization");
		System.out.println("Header ---  "+header);
		
		String token=null;
		String usernameFromToken=null;
		if(header!=null && header.startsWith("Bearer ")) {
			 token = header.substring(7);
			try {
				 usernameFromToken = util.getUsernameFromToken(token);
				 System.out.println(token+"   Token --  "+usernameFromToken);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Token is expired");
			}
		     
			
		}else {
			System.out.println("JWT is not Begin with Bearer");
		}
		
		if(usernameFromToken !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = service.loadUserByUsername(usernameFromToken);
			if(util.validateJwtToken(token)) {
				UsernamePasswordAuthenticationToken usernamePassToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePassToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

	
}
