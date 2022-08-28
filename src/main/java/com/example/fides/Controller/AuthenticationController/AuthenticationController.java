package com.example.fides.Controller.AuthenticationController;
import com.example.fides.Config.User.CustomUserDetails;
import com.example.fides.Config.User.CustomUserService;
import com.example.fides.Config.User.JwtUtil;
import com.example.fides.Entity.User.User;
import com.example.fides.Model.AuthenticationRequest;
import com.example.fides.Model.AuthenticationResponse;
import com.example.fides.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		CustomUserDetails userdetails = (CustomUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		User user = userdetails.getUser();
		userService.lastLogin(user);
		String token = jwtUtil.generateToken(userdetails);
		AuthenticationResponse response = new AuthenticationResponse();
		response.setToken(token);
		response.setId(user.getUserId());
		response.setUsername(user.getUserName());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		return ResponseEntity.ok(response);
	}


}