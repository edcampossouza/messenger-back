package br.com.ecstech.messenger.service;

import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.model.Role;
import br.com.ecstech.messenger.repository.ApplicationUserRepository;
import br.com.ecstech.messenger.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationUserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public ApplicationUser getLoggedInOrThrow() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            String username = jwt.getSubject();
            return findByUsername(username);
        } else {
            throw new IllegalStateException("User not authenticated");
        }
    }

    public ApplicationUser findByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public ApplicationUser registerUser(String username, String password, Set<Role> authorities) {
        String encoded = passwordEncoder.encode(password);
        ApplicationUser user = new ApplicationUser(username, encoded, authorities);
        return repository.save(user);
    }

    public ApplicationUser registerUser(String username, String password, Role authority) {
        Set<Role> authorities = new HashSet<>();
        authorities.add(authority);
        return registerUser(username, password, authorities);
    }

    public ApplicationUser registerRegularUser(String username, String password) {
        Role role = roleRepository.findByAuthority("USER").orElseThrow(() -> new IllegalStateException("No USER role"));
        return this.registerUser(username, password, role);
    }

    public List<ApplicationUser> getAdminUsers() {
        return repository.findByAuthorities_Authority("ADMIN");
    }

}
