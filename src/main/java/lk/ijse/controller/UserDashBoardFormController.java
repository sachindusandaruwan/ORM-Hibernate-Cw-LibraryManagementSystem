package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.util.DateAndTime;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class UserDashBoardFormController {


    @FXML
    private AnchorPane contentContext;

    @FXML
    private Label lblDateAndTime;

    public void initialize() throws IOException {
        DateAndTime.manageDateAndTime(lblDateAndTime);
        Navigation.switchPaging(contentContext,"UserDashEnterForm.fxml","Order");

    }

    @FXML
    void btnAccountSettingOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(contentContext,"AccountForm.fxml","Account");


    }

    @FXML
    void btnOrder(ActionEvent event) throws IOException {
        Navigation.switchPaging(contentContext,"OrderForm.fxml","Order");


    }

    @FXML
    void btnUserShowDetails(ActionEvent event) throws IOException {
        Navigation.switchPaging(contentContext,"UserDashEnterForm.fxml","Order");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));

        Scene scene = new Scene(rootNode);

         Stage stage = new Stage();
        stage.setTitle("home page");

        stage.setScene(scene);
        stage.show();

    }

}
