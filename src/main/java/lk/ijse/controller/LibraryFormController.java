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
import lk.ijse.dto.BookDto;
import lk.ijse.service.BookService;
import lk.ijse.service.ServiceFactory;
import lk.ijse.tmList.BookTm;
import lk.ijse.tmList.UserTm;

import java.io.IOException;
import java.util.List;

import static lk.ijse.controller.UserManageFormController.stage;

public class LibraryFormController {

    @FXML
    private TableColumn<?, ?> colAutor;

    @FXML
    private TableColumn<?, ?> colBName;

    @FXML
    private TableColumn<?, ?> colB_Id;

    @FXML
    private TableColumn<?, ?> colGener;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colPubDate;

    @FXML
    private TableView<BookTm> tblBookManage;

    @FXML
    private ImageView userMangement;

    @FXML
    private TableColumn<?, ?> colAvailability;

    BookService bookService=(BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);

    public void initialize(){
        setCellValuesFactory();
        getAllBooks();
    }

    private void getAllBooks() {
        List<BookDto> allbooks=bookService.getAllBooks();

        ObservableList<BookTm> obList=FXCollections.observableArrayList();
        for (BookDto bookDto:allbooks){
            obList.add(
                    new BookTm(
                            bookDto.getB_Id(),
                            bookDto.getB_Name(),
                            bookDto.getB_Autor(),
                            bookDto.getGener(),
                            bookDto.getPublicationDate(),
                            bookDto.getB_Price(),
                            bookDto.getAvailability()
                    )
            );
        }
        tblBookManage.setItems(obList);


//        ObservableList<UserTm> obList= FXCollections.observableArrayList();
//        for(UserDto userDto:allUsers){
//            obList.add(
//                    new UserTm(
//                            userDto.getId(),
//                            userDto.getName().getFirstName()+" "+userDto.getName().getMiddleName(),
//                            userDto.getAge(),
//                            userDto.getCity(),
//                            userDto.getEMail(),
//                            userDto.getPhoneNo()
//
//                    )
//            );
//        }
//        tblUser.setItems(obList);
    }

    private void setCellValuesFactory() {
        colB_Id.setCellValueFactory(new PropertyValueFactory<>("b_Id"));
        colBName.setCellValueFactory(new PropertyValueFactory<>("b_Name"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("b_Autor"));
        colGener.setCellValueFactory(new PropertyValueFactory<>("gener"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colPubDate.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("b_Price"));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/BookUpdateDeleteForm.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);

        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/BookUpdateDeleteForm.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);

        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void btnViewBookOnAction(ActionEvent event) {

    }
    @FXML
    void btnAddOnActiom(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BookAddFrom.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
