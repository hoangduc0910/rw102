package backend.controller;

import backend.IQLAccount;
import backend.service.IQLAccountService;
import backend.service.impl.QLAccountServiceImpl;
import entity.Account;

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
}
