package lk.ijse.tmList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderTm {

    private long orderId;
    private String bookName;
    private String user;
    private String  returnedDate;
    private String dueDate;
    private long bId;


}
