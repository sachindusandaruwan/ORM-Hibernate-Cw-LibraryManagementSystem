package lk.ijse.tmList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BookTm {
    private long b_Id;
    private String b_Name;
    private String b_Autor;
    private String gener;
    private String publicationDate;
    private double b_Price;
    private String availability;
}
