package com.mycompany.artbalear.NewUser;

import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void sendMessage(String destinatario, String contraseña) {

        Properties credencialesCorreo = new Properties();
        try {
            credencialesCorreo.load(SendEmail.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        final String username = credencialesCorreo.getProperty("correo");
        final String password = credencialesCorreo.getProperty("password");

        credencialesCorreo.put("mail.smtp.host", credencialesCorreo.getProperty("host"));
        credencialesCorreo.put("mail.smtp.port", credencialesCorreo.getProperty("port"));
        credencialesCorreo.put("mail.smtp.auth", credencialesCorreo.getProperty("auth"));
        credencialesCorreo.put("mail.smtp.starttls.enable", credencialesCorreo.getProperty("tls"));

        Session session = Session.getInstance(credencialesCorreo,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
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
