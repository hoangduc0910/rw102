package backend.service;

import entity.Account;
import entity.Department;
import entity.Position;

import java.util.List;

public interface IQLAccountService {
    List<Account> findAll();

    List<Account> findByUserName(String name);

    boolean deleteAccountByName(String userName);

    boolean updateFullNameByUsername(String userName, String fullName);

    List<Position> getAllPosition();

    List<Department> getallDepartment();

    boolean themMoiAccount(Account account);

    boolean exitsByUserName(String username);

    boolean exitsByEmail(String email);

    boolean deleteIfExits(String userName);

}
