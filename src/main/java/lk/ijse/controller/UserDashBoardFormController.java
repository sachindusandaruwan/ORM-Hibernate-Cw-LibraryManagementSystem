package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
        Navigation.switchPaging(contentContext,"OrderForm.fxml","Order");
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
    void btnexit(ActionEvent event) {

    }

}
