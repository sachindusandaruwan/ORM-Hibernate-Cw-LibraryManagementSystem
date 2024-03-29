package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class PlaceOrderDto {
    private long orderId;
    private long u_Id;
    private long b_Id;
    private LocalDate dueDate;
}
