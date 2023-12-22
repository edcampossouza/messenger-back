package br.com.ecstech.messenger.repository;

import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(ApplicationUser sender);

    List<Message> findBySender_Username(String username);
    List<Message> findByReceiver_Username(String username);

}
