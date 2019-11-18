package fr.ocr.authentication;

import fr.ocr.userdetails.UserWebUserDetails;
import fr.ocr.userdetails.UserWebUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserWebUserDetailsService userWebUserDetailsService;

	public CustomAuthenticationProvider() {
        super();
    }
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
		final String password = authentication.getCredentials().toString();

		UserWebUserDetails userWebUserDetails = userWebUserDetailsService.doesUserExist(authentication);

		if (userWebUserDetails == null || ! userWebUserDetails.getUsername().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(userWebUserDetails.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<GrantedAuthority> authorities = userWebUserDetails.getAuthorities();

		//authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        //final UserWebUserDetails principal = new User(username, password, authorities);

		//userWebUserDetails.setAuthorities(authorities);

		return new UsernamePasswordAuthenticationToken(userWebUserDetails, password, authorities);
	}
	
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}