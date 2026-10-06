package backend.service.impl;

import backend.IQLDepartment;
import backend.repository.IQLDepartmentRepository;
import backend.repository.impl.QLDepartmentRepositoryImpl;
import backend.service.IQLDepartmentService;
import entity.Department;

import java.util.List;

public class QLDepartmentServiceImpl implements IQLDepartmentService {

    private IQLDepartmentRepository repository;

    public QLDepartmentServiceImpl (){
        repository = new QLDepartmentRepositoryImpl();
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Department> findByDepartmentName(String name) {
        return repository.findByDepartmentName(name);
    }

    @Override
    public boolean deleteDepartmentByName(String name) {
        return repository.deleteDepartmentByName(name);
    }

    @Override
    public boolean updateDepById(int departmentId, String name) {
        return repository.updateDepById(departmentId, name);
    }
}
