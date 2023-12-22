package br.com.ecstech.messenger.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageDTO {
    @NotNull
    private String text;

    @NotNull
    private String receiverName;
}
