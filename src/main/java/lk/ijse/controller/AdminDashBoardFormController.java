package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
        Navigation.switchPaging(contentContext,"UserManageForm.fxml","Dashboard");
    }


    @FXML
    void btnBookManageOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchesManageOnAction(ActionEvent event) {

    }

    @FXML
    void btnHistoryDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserManageOnAction(ActionEvent event) {

    }

}
