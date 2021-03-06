package com.atriumwindows.pdf;

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
    private static String replyToName;
    private static String bcc1, bcc2;

    static {
        host = EmailProperties.getInstance().getProperty("host");
        port = Integer.parseInt(EmailProperties.getInstance().getProperty("port"));
        replyTo = EmailProperties.getInstance().getProperty("replyto");
        replyToName = EmailProperties.getInstance().getProperty("replytoname");
        bcc1 = EmailProperties.getInstance().getProperty("bccbox1");
        bcc2 = EmailProperties.getInstance().getProperty("bccbox2");
    }


    public boolean sendEmail(String toAddr, List<String> attchmentsList, String title, String message) {
        // Create the email message
        try {
            //Create the email
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(host);
            email.setSmtpPort(port);
            email.setFrom(replyTo, replyToName);
            email.setSubject(title);
            email.setMsg(message);
            email.addTo(toAddr);
            email.addBcc(bcc1);
            email.addBcc(bcc2);


            // Create the attachment
            for(String filename:attchmentsList) {

                String invoiceName = filename.substring(filename.lastIndexOf("Invoice"), filename.lastIndexOf('_'));

                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(filename);
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription(invoiceName);
                attachment.setName(invoiceName + ".pdf");

                // add the attachment
                email.attach(attachment);
            }

            // send the email
            email.send();

            /*  LOGGER: TO DO */

        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }





}
