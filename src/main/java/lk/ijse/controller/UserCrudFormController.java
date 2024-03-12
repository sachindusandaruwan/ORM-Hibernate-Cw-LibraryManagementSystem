package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.UserDto;
import lk.ijse.embeded.NameIdentifier;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

public class UserCrudFormController {

    @FXML
    private TextField TxtCity;

    @FXML
    private AnchorPane paneDelUpDSearch;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTelNo;

    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void SearchNameOnAction(ActionEvent event) {

    }


    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Long id= Long.valueOf(txtId.getText());
//        UserDto customerDto = userService.getUser(Long.valueOf(id));
        UserDto userDto=getDto(id);

        try {
            boolean isDeleted=userService.deleteUser(userDto);
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
        txtEmail.setText("");
        txtTelNo.setText("");
        txtAge.setText("");
        txtName.setText("");
        TxtCity.setText("");
    }

    public UserDto getDto(long id){
        UserDto userDto=userService.getUser(id);
        return userDto;
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        long id= Long.parseLong(txtId.getText());
        UserDto userDto=getDto(id);

        try{
            System.out.println(userDto);

            userDto=setNewValuesToEntity(userDto);

            System.out.println(userDto);


            boolean isUpdated=userService.updateUser(userDto);

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"User Update !!").show();
            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"User not Updated !!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private UserDto setNewValuesToEntity(UserDto userDto) {
        String [] parts = splitName(txtName.getText());
        userDto.setName(new NameIdentifier(parts[0],parts[1],parts[2]));
        userDto.setAge(Integer.parseInt(txtAge.getText()));
        userDto.setCity(TxtCity.getText());
        userDto.setEMail(txtEmail.getText());
        userDto.setPhoneNo(txtTelNo.getText());
        return userDto;
    }
    private String[] splitName(String name){
        return name.split(" ");
    }

    @FXML
    void searchIdOnAction(ActionEvent event) {
        Long Id= Long.valueOf(txtId.getText());
        try {
//            UserDto userDto= userService.getUser(Id);
            UserDto userDto=getDto(Id);
            if (userDto != null){
                fillFields(userDto);
            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"User not found!!!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void fillFields(UserDto userDto) {
        txtId.setText(String.valueOf(userDto.getId()));
        txtName.setText(userDto.getName().getFirstName()+" "+userDto.getName().getMiddleName()+" "+userDto.getName().getLastName());
        txtAge.setText(String.valueOf(userDto.getAge()));
        txtEmail.setText(userDto.getEMail());
        txtTelNo.setText(userDto.getPhoneNo());
        TxtCity.setText(userDto.getCity());
    }


}
