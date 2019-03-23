package cn.tigers.commons.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by tigershome on 2019/1/23.
 */
@Configuration
public class MailConfig {

    private String sendHost;

    private String sendPort;

    private String username;

    private String password;

    @Bean
    public JavaMailSenderImpl getJavaMailSenderImpl() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(sendHost);
        javaMailSender.setPort(Integer.valueOf(sendPort));
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");

        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.socketFactory", sf);
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.socketFactory.port", "587");
            properties.put("mail.smtp.socketFactory.fallback", "true");
        } catch (GeneralSecurityException e) {
            System.out.println("Init SSL Socket Factory error, this may cause that we can't connect to mail server or that we can't send a anonyme email");
        }
        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }
}
