package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dto.BookDto;
import lk.ijse.service.BookService;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;
import lk.ijse.tmList.BookTm;

import java.util.List;

public class UserDashEnterController {

    @FXML
    private TableColumn<?, ?> colAutor;

    @FXML
    private TableColumn<?, ?> colBName;

    @FXML
    private TableColumn<?, ?> colB_Id;

    @FXML
    private TableColumn<?, ?> colGener;

    @FXML
    private TableColumn<?, ?> colPubDate;

    @FXML
    private Label lblBooksCount;

    @FXML
    private Label lblMembersCount;

    @FXML
    private TableView<?> tblBookManage;
    BookService bookService=(BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);
    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    public void initialize(){
        setCellValueFactory();
        loadAllBooks();
        loadBookCount();
        loadMemberCount();

    }
    private void loadMemberCount() {
        lblMembersCount.setText(String.valueOf(userService.getCustomerCount()));
    }

    private void loadBookCount() {
        lblBooksCount.setText(String.valueOf(bookService.getBookCount()));
    }

    private void setCellValueFactory() {
        colB_Id.setCellValueFactory(new PropertyValueFactory<>("b_Id"));
        colBName.setCellValueFactory(new PropertyValueFactory<>("b_Name"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("b_Autor"));
        colGener.setCellValueFactory(new PropertyValueFactory<>("gener"));
       // colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colPubDate.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
       // colPrice.setCellValueFactory(new PropertyValueFactory<>("b_Price"));

    }

    void loadAllBooks(){
        ObservableList obList = FXCollections.observableArrayList();
        List<BookDto> allBooks = bookService.getAllBooks();
        for (BookDto bookDto : allBooks){
            obList.add(new BookTm(
                    bookDto.getB_Id(),
                    bookDto.getB_Name(),
                    bookDto.getB_Autor(),
                    bookDto.getGener(),
                    bookDto.getPublicationDate(),
                    bookDto.getB_Price(),
                    bookDto.getAvailability()

            ));
        }
        tblBookManage.setItems(obList);
    }

}
