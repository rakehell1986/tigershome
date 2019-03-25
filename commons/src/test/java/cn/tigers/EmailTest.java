package cn.tigers;

import cn.tigers.commons.thread.EmailRunnable;
import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by tigershome on 2019/1/23.
 */
public class EmailTest {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Test
    public void testEmail() {
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(******);
            javaMailSender.setPort(******);
            javaMailSender.setUsername("******");
            javaMailSender.setPassword("*******");



            Properties properties = new Properties();
            properties.put("mail.smtp.starttls.enable", "true");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.socketFactory", sf);
            properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.socketFactory.port","*****");
            properties.put("mail.smtp.socketFactory.fallback", "****");


            javaMailSender.setJavaMailProperties(properties);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setText("Hello This is a test email");

            MimeMessageHelper mimeMessageHelper = null;

            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setSubject("test");
            mimeMessageHelper.setTo(new String[]{"rakehell@live.cn", "wwei.miao@gmail.com"});
            mimeMessageHelper.setFrom("******");

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Create MimeMEssageHelper Error : " + e.getMessage());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            System.out.println("General Security Exception during mail sending");
        }
    }
}
