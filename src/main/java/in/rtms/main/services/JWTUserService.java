package in.rtms.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.rtms.main.dao.UserDao;
import in.rtms.main.entities.UserEntity;

@Service
public class JWTUserService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userDao.loginCreater(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().getName());
		
		return User
				.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(authority)
				.build();
	}

}
