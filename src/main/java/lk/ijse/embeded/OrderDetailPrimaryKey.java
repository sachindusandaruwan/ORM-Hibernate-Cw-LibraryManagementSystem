package lk.ijse.embeded;

import lk.ijse.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable

public class OrderDetailPrimaryKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;
    @Column
    private long b_Id;
}
