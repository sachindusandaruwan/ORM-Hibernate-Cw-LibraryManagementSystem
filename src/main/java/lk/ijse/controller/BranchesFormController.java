package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.dto.BranchDto;
import lk.ijse.service.BranchService;
import lk.ijse.service.ServiceFactory;

import java.io.IOException;
import java.util.List;

import static lk.ijse.controller.UserManageFormController.stage;

public class BranchesFormController {

    @FXML
    private TableColumn<?, ?> colBookTotal;

    @FXML
    private TableColumn<?, ?> colBranchHead;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<?> tblBranches;

    @FXML
    private ImageView userMangement;
    BranchService branchService = (BranchService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BRANCH);

    public void initialize(){
        setCellValueFactory();
        loadDataToTable();
    }



    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("branch_Id"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colBookTotal.setCellValueFactory(new PropertyValueFactory<>("bookTotal"));
        colBranchHead.setCellValueFactory(new PropertyValueFactory<>("headName"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("telNo"));
    }

    private void loadDataToTable() {
        ObservableList obList = FXCollections.observableArrayList();
        List<BranchDto> all =  branchService.getAllBranches();
        for (BranchDto branchDto : all){
            obList.add(branchDto);
        }
        tblBranches.setItems(obList);
    }


    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AddBranchForm.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void btnClickHere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BranchDeleteUpdateForm.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
