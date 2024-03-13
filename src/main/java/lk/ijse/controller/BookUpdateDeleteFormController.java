package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dto.BookDto;
import lk.ijse.service.BookService;
import lk.ijse.service.ServiceFactory;

import java.io.IOException;
import java.time.LocalDate;

public class BookUpdateDeleteFormController {

    @FXML
    private ComboBox<String> cmbAvailability;

    @FXML
    private ComboBox<String> cmbGener;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtBookPrice;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;
    static Stage stage = new Stage();
    BookService bookService=(BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);

    public void initialize(){
        loadStatusValues();
        loadBookGenresToGenreComboBox();
    }
    private void loadStatusValues() {
        String [] availablity ={"Available","NotAvailable"};
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String ava : availablity){
            obList.add(ava);
        }
        cmbAvailability.setItems(obList);
    }
    public void loadBookGenresToGenreComboBox(){
        String [] genres = {"Biography", "Science", "Fantasy", "Romance", "Mystery", "Poetry", "Children's'", "Cookbooks", "Travel", "Historical-Fiction", "Self-Help"};
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String genre : genres){
            obList.add(genre);
        }
        cmbGener.setItems(obList);
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException {
        Long id= Long.valueOf(txtId.getText());
//        UserDto customerDto = userService.getUser(Long.valueOf(id));
        BookDto bookDto=bookService.getBook(id);

        try {
            boolean isDeleted=bookService.deleteBook(bookDto);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Book iS Deleted !!").show();
                clearFields();

            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"Book is not Deleted !!");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAutor.setText("");
        txtDate.setValue(null);
        txtBookPrice.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        long id= Long.parseLong(txtId.getText());
        BookDto bookDto=bookService.getBook(id);

        try{
            System.out.println(bookDto);

            bookDto=setNewValuesToEntity(bookDto);

            System.out.println(bookDto);


            boolean isUpdated=bookService.updateBook(bookDto);

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Book Update !!").show();
                clearFields();
            }
            else {
                new Alert(Alert.AlertType.INFORMATION,"Book not Updated !!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private BookDto setNewValuesToEntity(BookDto bookDto) {
        bookDto.setB_Id(Long.parseLong(txtId.getText()));
        bookDto.setB_Name(txtName.getText());
        bookDto.setB_Autor(txtAutor.getText());
        bookDto.setGener((String) cmbGener.getValue());
        bookDto.setPublicationDate(String.valueOf(txtDate.getValue()));
        bookDto.setB_Price(Double.parseDouble(txtBookPrice.getText()));
        bookDto.setAvailability((String) cmbAvailability.getValue());
        return bookDto;
    }

    @FXML
    void txtSearchBookOnAction(ActionEvent event) {
        long id= Long.parseLong(txtId.getText());
        try {
            BookDto bookDto=bookService.getBook(id);
            if (bookDto != null){
                fillFields(bookDto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void fillFields(BookDto bookDto) {
        txtId.setText(String.valueOf(bookDto.getB_Id()));
        txtName.setText(bookDto.getB_Name());
        txtAutor.setText(bookDto.getB_Autor());

        txtDate.setValue(LocalDate.parse(bookDto.getPublicationDate()));
        txtBookPrice.setText(String.valueOf(bookDto.getB_Price()));

    }

}
