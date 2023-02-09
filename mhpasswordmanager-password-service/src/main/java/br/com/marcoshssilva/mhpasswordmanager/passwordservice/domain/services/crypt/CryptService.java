package br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.crypt;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public interface CryptService {
    byte[] encrypt(byte[] payload, String secret);

    byte[] decrypt(byte[] payload, String secret);

    default String convertByteToString(byte[] payload) {
        return new String(payload, StandardCharsets.UTF_8);
    }

    default byte[] convertStringToByte(String payload) {
        return payload.getBytes(StandardCharsets.UTF_8);
    }
}
