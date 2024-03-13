package lk.ijse.dto;

import lk.ijse.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BranchDto {
    private long branch_Id;
    private String location;
    private int bookTotal;
    private String headName;
    private String telNo;

    public BranchDto(String location, int bookTotal, String headName, String telNo) {
        this.location = location;
        this.bookTotal = bookTotal;
        this.headName = headName;
        this.telNo = telNo;
    }

    public Branch toEntity() {
        Branch branch=new Branch();
        branch.setBranch_Id(this.branch_Id);
        branch.setLocation(this.location);
        branch.setBookTotal(this.bookTotal);
        branch.setHeadName(this.headName);
        branch.setTelNo(this.telNo);
        return branch;
    }
}
