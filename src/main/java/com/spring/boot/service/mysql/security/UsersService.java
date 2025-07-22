package com.spring.boot.service.mysql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.dbmodel.mysql.Users;
import com.spring.boot.pojo.SBUsersDetails;
import com.spring.boot.repository.mysql.UsersRepository;

@Service
public class UsersService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

	@Autowired
	private JWTService jwtService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users user = usersRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User is not found :: " + username);
		}
		return 	new SBUsersDetails(user);
	}
	
	
	public Users registerUser(Users user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
		return user;
	}

}
