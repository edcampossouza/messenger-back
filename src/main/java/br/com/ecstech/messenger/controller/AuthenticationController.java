package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.dto.LoginDTO;
import br.com.ecstech.messenger.dto.AuthResponseDTO;
import br.com.ecstech.messenger.dto.RegisterDTO;
import br.com.ecstech.messenger.service.AuthenticationService;
import br.com.ecstech.messenger.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.AUTH_BASE_PATH)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping(Constants.SIGNUP_ROUTE)
    public AuthResponseDTO signup(@Valid @RequestBody RegisterDTO registerDTO) {
        return authenticationService.userSignup(registerDTO);
    }

    @PostMapping(Constants.LOGIN_ROUTE)
    public AuthResponseDTO login(@Valid @RequestBody LoginDTO loginDto) {
        return authenticationService.userLogin(loginDto.getUsername(), loginDto.getPassword());
    }
}
