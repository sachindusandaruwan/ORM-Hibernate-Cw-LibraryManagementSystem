package lk.ijse.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.Launcher;
import lk.ijse.dto.UserDto;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

import java.io.IOException;

public class LoginFormController {



    @FXML
    private Hyperlink hyperlinkDontHaveAccount;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;
    public static String userName;
    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        userName = txtUsername.getText();
        if (txtUsername.equals(null) || txtUsername.getText().equals("admin")) {

            Launcher.stageLogIn.close();

            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/adminDashBoardForm.fxml"));

            Scene scene = new Scene(rootNode);

            Stage stage = new Stage();
            stage.setTitle("home page");

            stage.setScene(scene);
            stage.show();

        }
        else if (checkExists(txtUsername.getText())){
            if (getUser(txtUsername.getText(), txtPassword.getText())) {
                loading();

            }else {
                new Alert(Alert.AlertType.INFORMATION, "Password Incorrect!").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Please Enter Valid Username!").show();
        }

        /*else {
            Launcher.stageLogIn.close();

            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/UserDashBoardForm.fxml"));

            Scene scene = new Scene(rootNode);

            Stage stage = new Stage();
            stage.setTitle(" page");

            stage.setScene(scene);
            stage.show();

        }*/

    }

    private void loading() throws IOException {
        Launcher.stageLogIn.close();

        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/UserDashBoardForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();
        stage.setTitle(" page");

        stage.setScene(scene);
        stage.show();
    }

    private boolean getUser(String userName, String password) {
        UserDto userDto = userService.getUserUsingUsername(userName);
        return userDto.getPassword().equals(password);
    }

    private boolean checkExists(String userName) {

            boolean x = userService.isExists(userName);
            //System.out.println(x);
            return x;

    }

    @FXML
    void hyperlinkSignInOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signInForm.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root, 1200, 676);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sign In Form");
        stage.show();

    }

}
