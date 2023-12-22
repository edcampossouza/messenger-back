package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.dto.SendMessageDTO;
import br.com.ecstech.messenger.dto.SendMessageResponseDTO;
import br.com.ecstech.messenger.service.MessageService;
import br.com.ecstech.messenger.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.MESSAGES_PATH)
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("")
    public SendMessageResponseDTO sendMessage(@Valid @RequestBody SendMessageDTO messageDTO) {
        return messageService.sendMessage(messageDTO);
    }
}
