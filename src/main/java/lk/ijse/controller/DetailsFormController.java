package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrdersDto;
import lk.ijse.dto.UserDto;
import lk.ijse.service.*;
import lk.ijse.tmList.OrderTm;
import lk.ijse.tmList.UserBookDetailTm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DetailsFormController {

    @FXML
    private TableColumn<?, ?> colB_Date;

    @FXML
    private TableColumn<?, ?> colB_Id;

    @FXML
    private TableColumn<?, ?> colB_Nmae;

    @FXML
    private TableColumn<?, ?> colDDate;

    @FXML
    private TableColumn<?, ?> colO_Id;

    @FXML
    private TableColumn<?, ?> colRDate;

    @FXML
    private TableColumn<?, ?> colU_Id;

    @FXML
    private TableView<?> tblOrderBookDetails;
    @FXML
    private TextField txtOrderId;

    @FXML
    private ImageView userMangement;

    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOK);

    OrderService orderService = (OrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.ORDER);

    OrderDetailService orderDetailService = (OrderDetailService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.ORDER_DETAIL);
    UserService userService=(UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USER);

    ReturnBookService returnBookService=(ReturnBookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.RETURN_BOOK);

    PlaceOrderService placeOrderService = (PlaceOrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);

    public void initialize() {
        setCellValueFactory();
        loadDataTotable();


        //System.out.println(UserDetailFormController.cusId);
        //cusId = UserDetailFormController.cusId;
    }

    @FXML
    void btnRetunOnAction(ActionEvent event) {
        OrdersDto ordersDto = orderService.get(Long.valueOf(txtOrderId.getText()));
        ordersDto.setReturnedDate(LocalDate.now());
        ordersDto.setStatus("returned");
        OrderDetailDto orderDetailDto = orderDetailService.get(ordersDto);
        BookDto bookDto = bookService.getBook(orderDetailDto.getBook().getB_Id());
        bookDto.setAvailability("available");
        orderService.updateOrder(ordersDto);
        bookService.updateBook(bookDto);
        if (returnBookService.returnBook(ordersDto, bookDto)){
            new Alert(Alert.AlertType.CONFIRMATION, "Book returned!").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "something went wrong").show();
        }


    }

    @FXML
    void txtSearchOrderId(ActionEvent event) {

    }
    private void setCellValueFactory() {
        colO_Id.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colB_Nmae.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colB_Id.setCellValueFactory(new PropertyValueFactory<>("bId"));
        //colB_Date.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        colDDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        colU_Id.setCellValueFactory(new PropertyValueFactory<>("user"));
        //colOption.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    private void loadDataTotable() {
        ObservableList obList = FXCollections.observableArrayList();

        List<OrdersDto> all = orderService.getAllOrders();
        List<UserDto> userDtos = new ArrayList<>();
        List<OrderDetailDto> orderDetails = orderDetailService.getAllOD();
        List<BookDto> books = new ArrayList<>();

        for (OrdersDto ordersDto : all){
            userDtos.add(userService.getUser(ordersDto.getUser().getU_Id()));
        }

        for (OrderDetailDto orderDetailDto : orderDetails){
            books.add(bookService.getBook(orderDetailDto.getBook().getB_Id()));
        }

        for (int i=0; i<all.size(); i++){
            OrderTm orderTm = new OrderTm();
            orderTm.setOrderId(orderDetails.get(i).getOrderDetailPrimaryKey().getOrderId());
            String date = String.valueOf(orderService.get(orderDetails.get(i).getOrderDetailPrimaryKey().getOrderId()).getReturnedDate());
            orderTm.setDueDate(String.valueOf(all.get(i).getDueDate()));
            orderTm.setReturnedDate(date.equals(null) ? "Not Returned Yet" : date);
            orderTm.setUser(all.get(i).getUser().getName().getFirstName() + " " + all.get(i).getUser().getName().getMiddleName());
            orderTm.setBookName(orderDetails.get(i).getBook().getB_Name());
            orderTm.setBId(orderDetails.get(i).getBook().getB_Id());
            //orderTm.getBookId(orderDetails.get(i).getBook().getB_Id());
            obList.add(orderTm);
        }

        tblOrderBookDetails.setItems(obList);
    }

    private void returnBook() {
    }


}
