package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Branch;
import lk.ijse.service.BranchService;
import lk.ijse.service.ServiceFactory;

public class BranchDeleteUpdateFormController {

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

    BranchService branchService=(BranchService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BRANCH );

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Long id= Long.valueOf(txtId.getText());

        BranchDto branchDto=branchService.getBranch(id);

        try {
            boolean isDeleted=branchService.deleteUser(branchDto);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"User iS Deleted !!").show();
                clearFields();

            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"User is not Deleted !!");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void clearFields() {
        txtId.setText("");
        txtLocation.setText("");
        txtHeadName.setText("");
        txtBookTotal.setText("");
        txtTel.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        long id= Long.parseLong(txtId.getText());
        BranchDto branchDto=branchService.getBranch(id);

        try{
            System.out.println(branchDto);

            branchDto=setNewValuesToEntity(branchDto);

            System.out.println(branchDto);


            boolean isUpdated=branchService.updateBranch(branchDto);

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Branch Update !!").show();
            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"Branch not Updated !!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private BranchDto setNewValuesToEntity(BranchDto branchDto) {
        branchDto.setBranch_Id(Long.parseLong(txtId.getText()));
        branchDto.setLocation(txtLocation.getText());
        branchDto.setBookTotal(Integer.parseInt(txtBookTotal.getText()));
        branchDto.setHeadName(txtHeadName.getText());
        txtTel.setText(txtTel.getText());
        return branchDto;
    }

    @FXML
    void txtSearchBranchOnId(ActionEvent event) {
        Long Id= Long.valueOf(txtId.getText());
        try {

            BranchDto branchDto=branchService.getBranch(Id);
            if (branchDto != null){
                fillFields(branchDto);
            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"User not found!!!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void fillFields(BranchDto branchDto) {
        txtId.setText(String.valueOf(branchDto.getBranch_Id()));
        txtLocation.setText(branchDto.getLocation());
        txtBookTotal.setText(String.valueOf(branchDto.getBookTotal()));
        txtHeadName.setText(branchDto.getHeadName());
        txtTel.setText(branchDto.getTelNo());
    }

}
