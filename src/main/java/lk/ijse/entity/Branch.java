package lk.ijse.entity;

import lk.ijse.dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "branch")

public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="branch_Id")
    private long branch_Id;

    @Column
    private String location;

    @Column
    private int bookTotal;

    @Column
    private String headName;

    @Column
    private String telNo;

    public BranchDto toDto() {
        BranchDto branchDto=new BranchDto();
        branchDto.setBranch_Id(this.branch_Id);
        branchDto.setLocation(this.location);
        branchDto.setBookTotal(this.bookTotal);
        branchDto.setHeadName(this.headName);
        branchDto.setTelNo(this.telNo);
        return branchDto;
    }
}
