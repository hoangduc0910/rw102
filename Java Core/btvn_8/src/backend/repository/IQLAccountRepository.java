package backend.repository;

import entity.Account;

import java.util.List;

public interface IQLAccountRepository {
    List<Account> findAll();

    List<Account> findByUserName(String name);

    boolean deleteAccountByName(String userName);

    boolean updateFullNameByUsername(String userName, String fullName);
}
