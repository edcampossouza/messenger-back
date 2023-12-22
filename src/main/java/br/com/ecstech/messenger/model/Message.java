package br.com.ecstech.messenger.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long messageId;


    @Getter
    @Setter
    private String text;


    @Getter
    @Setter
    @ManyToOne
    @JsonIgnore
    private ApplicationUser sender;

    @Getter
    @Setter
    @ManyToOne
    @JsonIgnore
    private ApplicationUser receiver;

    @JsonProperty("sender")
    public InnerUserDTO senderInfo() {
        return new InnerUserDTO(sender);
    }

    @JsonProperty("receiver")
    public InnerUserDTO receiverInfo() {
        return new InnerUserDTO(receiver);
    }

    @AllArgsConstructor
    public static class InnerUserDTO {
        @JsonIgnore
        private ApplicationUser user;

        public String getUsername() {
            return user.getUsername();
        }

        public Long getUserId() {
            return user.getUserId();
        }


    }
}