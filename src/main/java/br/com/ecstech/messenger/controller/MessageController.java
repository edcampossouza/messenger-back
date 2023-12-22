package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.dto.SendMessageDTO;
import br.com.ecstech.messenger.dto.SendMessageResponseDTO;
import br.com.ecstech.messenger.model.Message;
import br.com.ecstech.messenger.service.MessageService;
import br.com.ecstech.messenger.util.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constants.MESSAGES_PATH)
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("")
    public SendMessageResponseDTO sendMessage(@Valid @RequestBody SendMessageDTO messageDTO) {
        return messageService.sendMessage(messageDTO);
    }


    @GetMapping("")
    public List<Message> getMessages(
            @Pattern(regexp = "^(sent|received)$") @RequestParam(required = false) String type
    ) {
        if (type == null || type.equals("received"))
            return messageService.getReceivedMessages();
        else
            return messageService.getSentMessages();
    }
}
