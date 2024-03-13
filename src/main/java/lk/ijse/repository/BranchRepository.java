package lk.ijse.repository;

import lk.ijse.entity.Branch;
import org.hibernate.Session;

import java.util.List;

public interface BranchRepository extends CrudRepository<Branch, Long>{


    void setSession(Session session);

    List<Branch> getAll();
}
