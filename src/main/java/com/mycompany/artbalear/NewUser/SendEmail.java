package com.mycompany.artbalear.NewUser;

package com.mkyong;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public void sendMessage(String destinatario, String contraseña) {

        final String username = "balearart@gmail.com";
        final String password = "CalaPilar2021";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("balearart@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            message.setSubject("Registro de usuario Art Balear");
            message.setText("Bienvenido a Art Balear!"
                    + "\n\n Aqui tiene sus credenciales para iniciar sesión: " + "\n Correo: " + destinatario + "\n Contraseña: " + contraseña);

            Transport.send(message);

            System.out.println("Correo Enviado");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SendEmail sender = new SendEmail();
        sender.sendMessage("sergicladera@gmail.com", "njkgfbkjgfnbn");
    }

}
