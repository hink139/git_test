package com.example.fides.Config.User;
import com.example.fides.Entity.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -7002759807571810676L;
	
	private User user;

	Set<GrantedAuthority> authorities=null;

	public CustomUserDetails(User user) {
		this.user = user;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(this.user.getRole() != null){
			authorities.add(new SimpleGrantedAuthority(this.user.getRole().getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if (this.user.getStatus().equals(User.UserStatus.INACTIVE)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
     return true;
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	public String getUserId() {
		return this.user.getUserId();
	}

}
