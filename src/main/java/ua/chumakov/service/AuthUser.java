package ua.chumakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.chumakov.model.User;
import ua.chumakov.service.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by vesa-pk on 01.09.2017.
 */
@Service
public class AuthUser implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null)
            return null;
        else
            return new AuthUserDetails(user);
    }

    private class AuthUserDetails implements UserDetails {

        private User user;

        public AuthUserDetails(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return new HashSet<AuthRole>(Arrays.asList(new AuthRole(user.getUserRole().getRole())));
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        private class AuthRole implements GrantedAuthority {
            private String role;

            public AuthRole(String role) {
                this.role = role;
            }

            @Override
            public String getAuthority() {
                return role;
            }
        }
    }
}
