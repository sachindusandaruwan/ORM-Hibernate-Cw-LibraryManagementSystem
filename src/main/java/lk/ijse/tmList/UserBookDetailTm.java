package lk.ijse.tmList;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class UserBookDetailTm {
    private int o_Id;
    private String b_Name;
    private long b_Id;
    //private LocalDate date;
    private LocalDate dueDate;
    private String returnedDate;
    private long u_Id;
    private JFXButton button;
}
