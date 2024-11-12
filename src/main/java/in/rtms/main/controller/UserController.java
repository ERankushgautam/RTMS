package in.rtms.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.rtms.main.dto.UserRequestDTO;
import in.rtms.main.dto.UserResponceDTO;
import in.rtms.main.dto.UserResponceJWTDTO;
import in.rtms.main.security.AuthService;
import in.rtms.main.security.JWTUtil;
import in.rtms.main.services.JWTUserService;
import in.rtms.main.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;
	
	@Autowired
	private JWTUserService jwtUserService;
	
	@Autowired
	private JWTUtil jwtUtil;

//  <--------------------------------------------------------------------------------------------------->	

//	http://localhost:1000/api/user/signin
	@PostMapping("/signin")
	public ResponseEntity<UserResponceDTO> signIn(@RequestBody UserRequestDTO userRequestDTO) {
		return new ResponseEntity<UserResponceDTO>(userService.saveUser(userRequestDTO), HttpStatus.OK);
	}

//  <--------------------------------------------------------------------------------------------------->

	@PostMapping("/login")
	public ResponseEntity<UserResponceJWTDTO> login(@RequestParam String username, @RequestParam String password) {

		this.authService.doAuthenticate(username, password);
		UserDetails userDetails = this.jwtUserService.loadUserByUsername(username);
		String token = this.jwtUtil.generateToken(username);

		UserResponceJWTDTO userResponceJWTDTO = UserResponceJWTDTO
				.builder()
				.token(token)
				.username(userDetails.getUsername())
				.build();
		return new ResponseEntity<UserResponceJWTDTO>(userResponceJWTDTO, HttpStatus.OK);

	}
	
//  <--------------------------------------------------------------------------------------------------->
	
	@GetMapping("/admin/get-users")
	public ResponseEntity<List<UserResponceDTO>> getAllUsers() {
		return new ResponseEntity<List<UserResponceDTO>>(userService.getAllUsers(), HttpStatus.OK);
	}

//  <--------------------------------------------------------------------------------------------------->
	
	
}
