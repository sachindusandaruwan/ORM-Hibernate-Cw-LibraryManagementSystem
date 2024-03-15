package lk.ijse.controller;

import com.google.protobuf.Message;
import com.mysql.cj.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.UserDto;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;
public class ForgetPasswordFormController {

    @FXML
    private TextField txtPin;

    @FXML
    private TextField txtUserName;
    private int randomValue;
    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);


    @FXML
    void btnLogInOnAction(ActionEvent event) {

    }

    @FXML
    void btnSentOnAction(ActionEvent event) {


    }

}
