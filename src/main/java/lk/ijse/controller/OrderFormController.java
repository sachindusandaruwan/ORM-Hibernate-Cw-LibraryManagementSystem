/*package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.projection.BookIdsAndAvailability;
import lk.ijse.repository.OrderRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.BookService;
import lk.ijse.service.ServiceFactory;
import lk.ijse.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.List;

public class OrderFormController {
    private Session session;
    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);


    OrderRepository orderRepository  = (OrderRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ORDER);


    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colBook_Id;

    @FXML
    private TableView<?> tblBooksdetail;

    @FXML
    private TextField txtSearch;

    @FXML
    private ImageView userMangement;


    @FXML
    void txtSearchBookNameOnAction(ActionEvent event) {

        String bookName=txtSearch.getText();
        System.out.println("test 1");
        List<BookIdsAndAvailability> bookIdsAndAvailabilities=bookService.getBookIdsAndAvailablityCustomerSearch(bookName);
        System.out.println("hiiii");
        ObservableList obList = FXCollections.observableArrayList();
        for (BookIdsAndAvailability bookIdsAndAvailability : bookIdsAndAvailabilities){
            obList.add(bookIdsAndAvailability);
            System.out.println(bookIdsAndAvailability);
        }

    }

}*/
package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lk.ijse.controller.Row.RowFormController;
import lk.ijse.dto.*;
import lk.ijse.projection.BookIdsAndAvailability;
import lk.ijse.repository.OrderRepository;
import lk.ijse.repository.RepositoryFactory;
import lk.ijse.service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderFormController {

    @FXML
    private TableColumn<?, ?> colbookIdAndAvailability;

    @FXML
    private TableView<?> tblBookIdAndAvailablity;

    @FXML
    private TextField txtSearchName;
    @FXML
    private VBox txtVbox;

    @FXML
    private ImageView userMangement;
    @FXML
    private TextArea txtArea;

    @FXML
    private Label lableCatagary;

    @FXML
    private Label lblAutor;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblPublishedDate;


    @FXML
    private TextField txtBookId;

    @FXML
    private DatePicker txtReturnDate;

    @FXML
    private Label lblUserName;
    @FXML
    private Label lblOrderId;
    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);

    OrderService orderService = (OrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.ORDER);

    OrderDetailService orderDetailService = (OrderDetailService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.ORDER_DETAIL);
    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    PlaceOrderService placeOrderService = (PlaceOrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);

    UserDto userDto;
    static long userId;
    public void initialize(){
        setName(LoginFormController.userName);
        setOrderId();

    }

    private void setName(String userName) {
        userDto = userService.getUserUsingUsername(userName);
        userId = userDto.getId();
        //System.out.println(cusId1);
        lblUserName.setText(userDto.getName().getFirstName()+" "+userDto.getName().getMiddleName()+" "+userDto.getName().getLastName());

    }

    private void setOrderId() {
        if (orderService.getOrderId() != -1){
            lblOrderId.setText(String.valueOf(orderService.getOrderId()));
            System.out.println("Hawa");
        }else {
            lblOrderId.setText("1");
        }

    }


    @FXML
    void btnAddOnActiom(ActionEvent event) {

    }

    @FXML
    void txtSearchBookNameOnAction(ActionEvent event) {
        String bookName = txtSearchName.getText();

        System.out.println("test 1");
        List<BookIdsAndAvailability> bookIdsAndAvailabilities = bookService.getBookIdsAndAvailablityCustomerSearch(bookName);
        System.out.println("hiiii");

//        ObservableList obList = FXCollections.observableArrayList();


//        for (BookIdsAndAvailability bookIdsAndAvailability : bookIdsAndAvailabilities) {
//            obList.add(bookIdsAndAvailability);
//            System.out.println(bookIdsAndAvailability);
//
//
//            System.out.println("anee");
//            }


        for (int i = 0; i < bookIdsAndAvailabilities.size(); i++) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Row/RowForm.fxml"));
            try {
                Parent root = fxmlLoader.load();
                RowFormController rowFormController = fxmlLoader.getController();
                rowFormController.setData(bookIdsAndAvailabilities.get(i).getBook_Id()+" - "+bookIdsAndAvailabilities.get(i).getAvailability());
                txtVbox.getChildren().add(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



//        txtArea.setText(String.valueOf(obList));

    }
    @FXML
    void txtSearchBookId(ActionEvent event) {
        long id= Long.parseLong(txtBookId.getText());
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
        lblBookName.setText(bookDto.getB_Name());
        lableCatagary.setText(bookDto.getGener());
        lblAutor.setText(bookDto.getB_Autor());
        lblPublishedDate.setText(bookDto.getPublicationDate());
    }
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        if (txtReturnDate.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Please set return date!").show();

        }
        if (checkUserAlreadyHadThisBook(Long.valueOf(txtBookId.getText()))){
            System.out.println("111111111111111");
            PlaceOrderDto placeOrderDto = new PlaceOrderDto(
                    Long.parseLong(lblOrderId.getText()),
                    userDto.getId(),
                    Long.parseLong(txtBookId.getText()),
                    txtReturnDate.getValue()

            );

            System.out.println(placeOrderDto);

            if (placeOrderService.placeOrder(placeOrderDto)){
                System.out.println("dan nm epa wela...");
                new Alert(Alert.AlertType.CONFIRMATION, "You Get it Successfully!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "something went wrong").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "you already have this book!").show();
        }



    }



    private boolean checkUserAlreadyHadThisBook(Long bookId) {
        List<OrdersDto> orderByCusId = orderService.getOrderByUserId(userDto);
        List<OrderDetailDto> orderDetailList = new ArrayList<>();

        for (OrdersDto ordersDto : orderByCusId){
            orderDetailList.add(orderDetailService.get(ordersDto));
        }

        for (OrderDetailDto orderDetailDto : orderDetailList){
            if (orderDetailDto.getBook().getB_Id() == bookId){
                System.out.println("222222222222222222222");
                return false;
            }

        }
        return true;
    }



}

