package lk.ijse.dto;

import lk.ijse.entity.Orders;
import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrdersDto {
    private long orderId;
    private LocalDate date;
    private LocalDate dueDate;
    private String status;
    private LocalDate returnedDate;
    private User user;

    public Orders toEntity(){
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setDateTime(date.atStartOfDay());
        orders.setDueDate(dueDate);
        orders.setStatus(status);
        orders.setReturnedDate(returnedDate);
        orders.setUser(user);
        return orders;
    }
}
