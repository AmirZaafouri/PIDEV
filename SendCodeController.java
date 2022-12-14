/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.challange.gui;


import edu.worshop.services.CodeCache;
import edu.worshop.services.EnvoyerEmail;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SendCodeController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtVer;
    int randomCode;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void sendpass(ActionEvent event) {
        String email = txtEmail.getText();
        System.out.println(email);
        try {
            EnvoyerEmail.sendMailForgotPass(email);
        } catch (Exception ex) {
            Logger.getLogger(SendCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Random rand = new Random();
//
//        randomCode = rand.nextInt(999999);
//
//        String host = "smtp.gmail.com";
//
//        String user = "ahmed.hachani@esprit.tn";
//
//        String pass = "213JMT3957";
//
//        String to = txtEmail.getText();
//
//        String subject = "Reseting Code";
//
//        String message = "Your reset code is " + randomCode;
//
//        boolean sessionDebug = false;
//
//        Properties pros = System.getProperties();
//
//        pros.put("mail.smtp.starttls.enable", "true");
//
//        pros.put("mail.smtp.host", "host");
//
//        pros.put("mail.smtp.port", "587");
//
//        pros.put("mail.smtp.auth", "true");
//
//        pros.put("mail.smtp.starttls.required", "true");
//
//        //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//        Session mailSession = Session.getDefaultInstance(pros, null);
//
//        mailSession.setDebug(sessionDebug);
//
//        Message msg = new MimeMessage(mailSession);
//
//        msg.setFrom(new InternetAddress(user));
//
//        InternetAddress[] address = {new InternetAddress(to)};
//
//        msg.setRecipients(Message.RecipientType.TO, address);
//
//        msg.setSubject(subject);
//
//        msg.setText(message);
//
//        Transport transport = mailSession.getTransport("smtp");
//
//        transport.connect(host, user, pass);
//
//        transport.sendMessage(msg, msg.getAllRecipients());
//
//        transport.close();
//
//        JOptionPane.showMessageDialog(null, "code has been send to the email");
        //catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane, ex);
//
//        }

//        Random rand = new Random();
//
//        randomCode = rand.nextInt(999999);
//
//        String host = "smtp.gmail.com";
//
//        String user = "ahmed.hachani@esprit.tn";
//
//        String pass = "213JMT3957";
//
//        String to = txtEmail.getText();
//
//        String subject = "Reseting Code";
//
//        String message = "Your reset code is " + randomCode;
//
//        boolean sessionDebug = false;
//
//        Properties pros = System.getProperties();
//
//        pros.put("mail.smtp.starttls.enable", "true");
//
//        pros.put("mail.smtp.host", "host");
//
//        pros.put("mail.smtp.port", "587");
//
//        pros.put("mail.smtp.auth", "true");
//
//        pros.put("mail.smtp.starttls.required", "true");
//
//        //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//        Session mailSession = Session.getDefaultInstance(pros, null);
//
//        mailSession.setDebug(sessionDebug);
//
//        Message msg = new MimeMessage(mailSession);
//
//        msg.setFrom(new InternetAddress(user));
//
//        InternetAddress[] address = {new InternetAddress(to)};
//
//        msg.setRecipients(Message.RecipientType.TO, address);
//
//        msg.setSubject(subject);
//
//        msg.setText(message);
//
//        Transport transport = mailSession.getTransport("smtp");
//
//        transport.connect(host, user, pass);
//
//        transport.sendMessage(msg, msg.getAllRecipients());
//
//        transport.close();
//
//        JOptionPane.showMessageDialog(null, "code has been send to the email");
        //catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane, ex);
//
//        }
    }

    @FXML
    public void verifycode(ActionEvent event) throws IOException {
        String seeked = txtEmail.getText();
        System.out.println(CodeCache.get(txtEmail.getText()));
        System.out.println(Integer.valueOf(txtVer.getText()).equals(CodeCache.get(txtEmail.getText())));
        if (Integer.valueOf(txtVer.getText()).equals(CodeCache.get(txtEmail.getText()))) {
            // if (true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resetCode.fxml"));
            root = loader.load();
            ResetCodeController rs = loader.getController();
            rs.setUser(seeked);
            txtEmail.getScene().setRoot(root);

            //ResetCodeController rs = new ResetCodeController(txtEmail.getText());
//            Parent root = FXMLLoader.load(getClass().getResource("resetCode.fxml"));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
            System.out.println(CodeCache.get(txtEmail.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "code do not match");

        }

    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("frontoffice.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
