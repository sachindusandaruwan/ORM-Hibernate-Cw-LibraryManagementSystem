package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.embeded.NameIdentifier;
import lk.ijse.entity.User;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

public class SigninFormController {

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFname;

    @FXML
    private TextField txtLname;

    @FXML
    private TextField txtMname;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;
    UserService userService = (UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);


    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void txtSignOnAction(ActionEvent event) {
        NameIdentifier nameIdentifier = new NameIdentifier(
                txtFname.getText(),
                txtMname.getText(),
                txtLname.getText()
        );
        Long id = userService.save(new User(
                nameIdentifier,
                Integer.parseInt(txtAge.getText()),
                txtCity.getText(),
                txtEmail.getText(),
                txtUsername.getText(),
                txtPassword.getText()
        ));
        if (id!=-1L){
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "something went wrong!").show();
        }

    }

}
