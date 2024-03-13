package lk.ijse.tmList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BranchTm {
    private long branch_Id;
    private String location;
    private int bookTotal;
    private String headName;
    private String telNo;
}
