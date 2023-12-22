package br.com.ecstech.messenger.utils;


import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@Getter
public class RSAKeyPair {

    private final RSAPrivateKey privateKey;

    private final RSAPublicKey publicKey;

    public RSAKeyPair() {
        KeyPair keyPair = KeyGeneratorUtility.generateRSaKey();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
    }
}
