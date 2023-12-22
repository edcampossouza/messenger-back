package br.com.ecstech.messenger.service;


import br.com.ecstech.messenger.dto.AuthResponseDTO;
import br.com.ecstech.messenger.dto.RegisterDTO;
import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApplicationUserService userService;

    public AuthResponseDTO userLogin(String username, String password) {
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (Exception e) {
            throw e;
        }
        String token = tokenService.generateJwt(auth);
        ApplicationUser user = userService.findByUsername(username);
        return new AuthResponseDTO(token, user);
    }

    public AuthResponseDTO userSignup(RegisterDTO registerDTO) {
        ApplicationUser user = userService.registerRegularUser(registerDTO.getUsername(), registerDTO.getPassword());
        return userLogin(registerDTO.getUsername(), registerDTO.getPassword());
    }

}
