package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.dto.UserDto;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;
import lk.ijse.tmList.UserTm;

import java.util.List;

public class UserManageFormController {

    @FXML
    private TableColumn<?, ?> ColU_Name;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colU_Id;

    @FXML
    private TableColumn<?, ?> colU_age;

    @FXML
    private TableView<UserTm> tblUser;

    @FXML
    private ImageView userMangement;
    @FXML
    private TableColumn<?, ?> colName;

    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    public void initialize(){
        setCellValueFactory();
        getAllUers();
    }

    private void getAllUers() {
        List<UserDto> allUsers=userService.getAllUsers();
        ObservableList<UserTm> obList= FXCollections.observableArrayList();
        for(UserDto userDto:allUsers){
            obList.add(
                    new UserTm(
                            userDto.getId(),
                            userDto.getName().getFirstName()+" "+userDto.getName().getMiddleName(),
                            userDto.getAge(),
                            userDto.getCity(),
                            userDto.getEMail(),
                            userDto.getPhoneNo()

                    )
            );
        }
        tblUser.setItems(obList);

    }

    private void setCellValueFactory() {
        colU_Id.setCellValueFactory(new PropertyValueFactory<>("u_Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colU_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        colU_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("eMail"));

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
