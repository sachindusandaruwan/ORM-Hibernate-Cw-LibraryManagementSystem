package lk.ijse.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookIdsAndAvailability {
    private long book_Id;
    private String availability;

    @Override
    public String toString(){
        return book_Id + " - " + availability;
    }
}
