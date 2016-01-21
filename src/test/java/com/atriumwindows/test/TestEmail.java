package com.atriumwindows.test;

import org.apache.commons.mail.*;
import org.junit.Test;

/**
 * Created by nni on 1/21/2016.
 */
public class TestEmail {



    @Test
    public void test() throws EmailException {

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("10.100.9.54");
        email.setSmtpPort(25);
        //email.setAuthenticator(new DefaultAuthenticator("wizmgr", "wizmgr"));
        //email.setSSLOnConnect(true);
        email.setFrom("wizmgr@atriumwindows.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("nni@atriumwindows.com");

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Invoice.pdf");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Invoice");
        attachment.setName("test.pdf");
        // add the attachment
        email.attach(attachment);

        attachment = new EmailAttachment();
        attachment.setPath("C:\\Invoice1.pdf");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Invoice");
        attachment.setName("test.pdf");

        // add the attachment
        email.attach(attachment);




        // send the email
        email.send();
    }
}
