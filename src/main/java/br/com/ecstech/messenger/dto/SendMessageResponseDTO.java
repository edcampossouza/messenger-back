package br.com.ecstech.messenger.dto;


import br.com.ecstech.messenger.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageResponseDTO {
    private Message message;
}
