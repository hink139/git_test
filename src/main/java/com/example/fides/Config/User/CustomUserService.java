package com.example.fides.Config.User;
import com.example.fides.Entity.User.User;
import com.example.fides.Repository.UserRepository;
import com.example.fides.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired private UserRepository userRepository;
	@Autowired private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {		

		Optional<User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		userRepository.save(user.get());
		CustomUserDetails details = new CustomUserDetails(user.get());
		return details;
	}


}
