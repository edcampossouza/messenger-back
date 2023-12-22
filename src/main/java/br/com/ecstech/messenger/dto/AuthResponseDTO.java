package br.com.ecstech.messenger.dto;


import br.com.ecstech.messenger.model.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponseDTO {
    private String token;
    private ApplicationUser user;
}
