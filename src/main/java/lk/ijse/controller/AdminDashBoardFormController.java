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

public class AdminDashBoardFormController {

    @FXML
    private AnchorPane contentContext;

    @FXML
    private Label lblDateAndTime;

    public void initialize() throws IOException {
        DateAndTime.manageDateAndTime(lblDateAndTime);
        Navigation.switchPaging(contentContext,"UserManageForm.fxml","Users");
    }


    @FXML
    void btnBookManageOnAction(ActionEvent event) throws IOException {

        Navigation.switchPaging(contentContext,"libraryForm.fxml","LibraryBooks");
    }

    @FXML
    void btnBranchesManageOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(contentContext,"BranchesForm.fxml","Branches");

    }

    @FXML
    void btnHistoryDetailsOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(contentContext,"DetailsForm.fxml","BookDetails");


    }

    @FXML
    void btnUserManageOnAction(ActionEvent event) {

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
