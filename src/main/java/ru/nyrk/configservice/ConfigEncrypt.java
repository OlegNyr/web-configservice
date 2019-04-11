package ru.nyrk.configservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.server.encryption.CipherEnvironmentEncryptor;
import org.springframework.cloud.config.server.encryption.EnvironmentEncryptor;
import org.springframework.cloud.config.server.encryption.SingleTextEncryptorLocator;
import org.springframework.cloud.config.server.encryption.TextEncryptorLocator;
import org.springframework.cloud.context.encrypt.EncryptorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Configuration
public class ConfigEncrypt {

    @Value("${key}")
    String key;

    @Bean
    public EnvironmentEncryptor environmentEncryptor() {
        return new CipherEnvironmentEncryptor(encryptor());
    }

    @Bean
    public TextEncryptorLocator encryptor() {
        return new SingleTextEncryptorLocator(textEncryptor());
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return new EncryptorFactory().create(key);
    }


}
