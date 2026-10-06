package backend.service.impl;

import backend.IQLAccount;
import backend.repository.IQLAccountRepository;
import backend.repository.impl.QLAccountRepositoryImpl;
import backend.service.IQLAccountService;
import entity.Account;

import java.util.List;

public class QLAccountServiceImpl implements IQLAccountService {
    private IQLAccountRepository repository;

    public QLAccountServiceImpl() {
            repository = new QLAccountRepositoryImpl();
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Account> findByUserName(String name) {
        return repository.findByUserName(name);
    }

    @Override
    public boolean deleteAccountByName(String userName) {
        return repository.deleteAccountByName(userName);
    }

    @Override
    public boolean updateFullNameByUsername(String userName, String fullName) {
        return repository.updateFullNameByUsername(userName, fullName);
    }
}
