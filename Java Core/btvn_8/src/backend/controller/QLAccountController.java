package backend.controller;

import backend.IQLAccount;
import backend.service.IQLAccountService;
import backend.service.impl.QLAccountServiceImpl;
import entity.Account;
import entity.Department;
import entity.Position;

import java.util.List;

public class QLAccountController {
    private IQLAccountService  accountService;

    public QLAccountController() {
        accountService = new QLAccountServiceImpl();
    }

    public List<Account> findAll() {
        return accountService.findAll();
    }

    public List<Account> findByUserName(String name) {
        return accountService.findByUserName(name);
    }

    public boolean deleteAccountByName(String userName) {
        return accountService.deleteAccountByName(userName);
    }

    public boolean updateFullNameByUsername(String userName, String fullName) {
        return accountService.updateFullNameByUsername(userName, fullName);
    }

    public List<Position> getAllPosition() {
        return accountService.getAllPosition();
    }

    public List<Department> getallDepartment() {
        return accountService.getallDepartment();
    }

    public boolean themMoiAccount(Account account) {
        return accountService.themMoiAccount(account);
    }

    public boolean exitsByUserName(String username) {
        return accountService.exitsByUserName(username);
    }

    public boolean exitsByEmail(String email) {
        return accountService.exitsByEmail(email);
    }

    public boolean deleteIfExits(String userName) {
        return accountService.deleteIfExits(userName);
    }
}
