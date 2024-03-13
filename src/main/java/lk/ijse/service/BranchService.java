package lk.ijse.service;

import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;

import java.util.List;

public interface BranchService extends SuperService{
    boolean save(BranchDto branchDto);

    List<BranchDto> getAllBranches();

    BranchDto getBranch(Long id);

    boolean updateBranch(BranchDto branchDto);

    boolean deleteUser(BranchDto branchDto);
}
