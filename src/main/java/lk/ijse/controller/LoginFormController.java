package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.Launcher;
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
