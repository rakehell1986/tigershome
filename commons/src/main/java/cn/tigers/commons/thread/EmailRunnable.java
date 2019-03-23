package cn.tigers.commons.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by tigershome on 2019/1/23.
 */
public class EmailRunnable implements Runnable {

    private String subject;

    private String from;

    private String to;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public EmailRunnable(String subject, String to) {
        this.subject = subject;
        this.to = to;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Create MimeMEssageHelper Error : " + e.getMessage());
        }
    }
}
