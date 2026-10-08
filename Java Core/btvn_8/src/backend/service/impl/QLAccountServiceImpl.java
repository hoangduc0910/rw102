package backend.service.impl;

import backend.IQLAccount;
import backend.repository.IQLAccountRepository;
import backend.repository.impl.QLAccountRepositoryImpl;
import backend.service.IQLAccountService;
import entity.Account;
import entity.Department;
import entity.Position;

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

    @Override
    public List<Position> getAllPosition() {
        return repository.getAllPosition();
    }

    @Override
    public List<Department> getallDepartment() {
        return repository.getallDepartment();
    }

    @Override
    public boolean themMoiAccount(Account account) {
        return repository.themMoiAccount(account);
    }

    @Override
    public boolean exitsByUserName(String username) {
        return repository.exitsByUserName(username);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return repository.exitsByEmail(email);
    }

    @Override
    public boolean deleteIfExits(String userName) {
        return repository.deleteIfExits(userName);
    }
}
