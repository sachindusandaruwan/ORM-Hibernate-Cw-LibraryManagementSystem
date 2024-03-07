package lk.ijse.tmList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserTm {
    private long id;
    private String name;
    private int age;
    private String city;
    private String eMail;
}
