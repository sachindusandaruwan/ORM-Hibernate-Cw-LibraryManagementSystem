package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.BookDto;
import lk.ijse.service.BookService;
import lk.ijse.service.ServiceFactory;
import lk.ijse.service.UserService;

public class BookAddFromController {

    @FXML
    private ComboBox<String> cmbGener;
    @FXML
    private ComboBox<String> cmbAvailability;


    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtBookPrice;



    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;
    @FXML
    private DatePicker txtDate;
    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);


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
    void btnAddOnAction(ActionEvent event) {
        long id= Long.parseLong(txtId.getText());
        String name=txtName.getText();
        String b_Autor=txtAutor.getText();
        String gener=cmbGener.getSelectionModel().getSelectedItem();
        String date=txtDate.getValue().toString();
        double price= Double.parseDouble(txtBookPrice.getText());
        String availability=cmbAvailability.getSelectionModel().getSelectedItem();

        BookDto dto=new BookDto(id,name,b_Autor,gener,date,price,availability);
        System.out.println("======================================");

        long Id=bookService.saveBook(dto);
        System.out.println("machan");
        System.out.println(Id);


        if (id!=-1L){
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "something went wrong!").show();
        }




    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAutor.setText("");
       txtBookPrice.setText("");

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

}
