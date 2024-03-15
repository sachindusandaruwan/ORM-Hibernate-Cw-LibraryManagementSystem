package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.dto.UserDto;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

public class AccountFormController {

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserName1;

    @FXML
    private Label lblUserName11;

    @FXML
    private Label lblUserName12;

    @FXML
    private Label lblUserName121;

    @FXML
    private Label lblUserName13;

    @FXML
    private Label lblUserName131;

    @FXML
    private Label lblUserName1311;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtCurrentPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private ImageView userMangement;

    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    public void initialize(){
        loadCustomer();
    }

    private void loadCustomer() {
        UserDto userDto = userService.getUserUsingUsername(LoginFormController.userName);
        lblUserName.setText(userDto.getName().getFirstName()+ " "+ userDto.getName().getMiddleName()+ " "+ userDto.getName().getLastName());
        txtCity.setText(userDto.getCity());
        txtAge.setText(String.valueOf(userDto.getAge()));
        txtEmail.setText(userDto.getEMail());
        txtUserName.setText(userDto.getUsername());
    }

    @FXML
    void btnChanePassword(ActionEvent event) {

        UserDto userDto = userService.getUserUsingUsername(LoginFormController.userName);
        if(userDto.getPassword().equals(txtCurrentPassword.getText())){
            if (!txtNewPassword.equals(null)){
                if (!txtConfirmPassword.equals(null)){
                    if (txtNewPassword.getText().equals(txtConfirmPassword.getText())){
                        userDto.setPassword(txtConfirmPassword.getText());
                        userService.updateUser(userDto);
                        new Alert(Alert.AlertType.CONFIRMATION, "Password Changed!").show();
                    }else {
                        txtConfirmPassword.setStyle("-fx-border-width: 2px; -fx-border-color: red");
                        new Alert(Alert.AlertType.WARNING, "New Password and you confirmed password should be same!").show();
                    }
                }else {
                    new Alert(Alert.AlertType.ERROR, "Please Enter password Again!").show();
                }
            }else {
                new Alert(Alert.AlertType.ERROR, "Please Enter New Password!").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Entered Password Incorrect!").show();
        }

    }

    @FXML
    void changeOnAction(ActionEvent event) {
        UserDto userDto = userService.getUserUsingUsername(LoginFormController.userName);
        userDto.setCity(txtCity.getText());
        userDto.setAge(Integer.parseInt(txtAge.getText()));
        userDto.setEMail(txtEmail.getText());
        userDto.setUsername(txtUserName.getText());
        if (userService.updateUser(userDto)){
            new Alert(Alert.AlertType.CONFIRMATION, "Details Updated!").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

    }

}
