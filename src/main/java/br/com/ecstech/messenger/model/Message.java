package br.com.ecstech.messenger.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Message {

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
    private ApplicationUser sender;

    @Getter
    @Setter
    @ManyToOne
    private ApplicationUser receiver;

}
