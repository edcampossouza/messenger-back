package br.com.ecstech.messenger.service;


import br.com.ecstech.messenger.dto.SendMessageDTO;
import br.com.ecstech.messenger.dto.SendMessageResponseDTO;
import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.model.Message;
import br.com.ecstech.messenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ApplicationUserService userService;

    public SendMessageResponseDTO sendMessage(SendMessageDTO messageDTO) {
        try {
            ApplicationUser to = userService.findByUsername(messageDTO.getReceiverName());
            ApplicationUser from = userService.getLoggedInOrThrow();
            Message message = new Message();
            message.setReceiver(to);
            message.setSender(from);
            message.setText(messageDTO.getText());
            messageRepository.save(message);
            return new SendMessageResponseDTO(message);
        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Message> getReceivedMessages() {
        ApplicationUser me = userService.getLoggedInOrThrow();
        return messageRepository.findByReceiver_Username(me.getUsername());
    }

    public List<Message> getSentMessages() {
        ApplicationUser me = userService.getLoggedInOrThrow();
        return messageRepository.findBySender_Username(me.getUsername());
    }
}
