package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dto.BranchDto;
import lk.ijse.service.BranchService;
import lk.ijse.service.ServiceFactory;

import java.util.List;

public class AddBranchFormController {

    @FXML
    private TextField txtBookTotal;

    @FXML
    private TextField txtHeadName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtTel;
    BranchService branchService = (BranchService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BRANCH);



    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (branchService.save(new BranchDto(
                txtLocation.getText(),
                Integer.parseInt(txtBookTotal.getText()),
                txtHeadName.getText(),
                txtTel.getText()

        ))){
            new Alert(Alert.AlertType.CONFIRMATION, "Branch Added Successfully!").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

}
