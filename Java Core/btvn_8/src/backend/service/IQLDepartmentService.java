package backend.service;

import entity.Department;

import java.util.List;

public interface IQLDepartmentService {
    List<Department> findAll();

    List<Department> findByDepartmentName(String name);

    boolean deleteDepartmentByName(String name);

    boolean updateDepById(int departmentId, String name);
}
