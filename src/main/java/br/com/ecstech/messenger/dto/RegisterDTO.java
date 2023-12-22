package br.com.ecstech.messenger.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
