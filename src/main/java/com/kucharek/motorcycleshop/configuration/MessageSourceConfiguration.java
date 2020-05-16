package com.kucharek.motorcycleshop.configuration;

import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.IOException;
import java.util.ResourceBundle;

@Configuration
public class MessageSourceConfiguration {

    @Bean
    public MessageSource messageSource() throws IOException {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public ResourceBundle resourceBundle() throws IOException {
        return ResourceBundle.getBundle(
                "com.kucharek.motorcycleshop.messages",
                YamlResourceBundle.Control.INSTANCE
        );
    }
}
