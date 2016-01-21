package com.atriumwindows.email;

import com.atriumwindows.utils.EmailProperties;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.util.List;

/**
 * Created by nni on 1/21/2016.
 */
public class SendEmail {

    private SendEmail(){}

    private static final SendEmail instance = new SendEmail();

    public static SendEmail getInstance() {
        return instance;
    }

    private static String host;
    private static int port;
    private static String replyTo;
    private static String message;

    static {
        host = EmailProperties.getInstance().getProperty("host");
        port = Integer.parseInt(EmailProperties.getInstance().getProperty("port"));
        replyTo = EmailProperties.getInstance().getProperty("replyto");
        message = EmailProperties.getInstance().getProperty("message");
    }

    public void testP() {
        System.out.println(host);
        System.out.println(port);
        System.out.println(replyTo);
    }

    public boolean sendEmail(String toAddr, List<String> attchmentsList, String title) {
        // Create the email message

        try {

            //Create the email
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(host);
            email.setSmtpPort(port);
            email.setFrom(replyTo);
            email.setSubject(title);
            email.setMsg(message);
            email.addTo(toAddr);


            // Create the attachment
            for(String filename:attchmentsList) {
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(filename);
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("Invoice");
                attachment.setName("invoice.pdf");

                // add the attachment
                email.attach(attachment);
            }

            // send the email
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }





}
