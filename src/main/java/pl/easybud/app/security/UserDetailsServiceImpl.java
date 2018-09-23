package pl.easybud.app.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.easybud.backend.data.entity.User;
import pl.easybud.backend.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByEmail(username);
		if (null == user) {
			throw new UsernameNotFoundException("Nie znaleziono użytkownika: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(),
					Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		}
	}
}