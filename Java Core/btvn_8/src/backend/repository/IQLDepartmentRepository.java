package backend.repository;

import entity.Department;

import java.util.List;

public interface IQLDepartmentRepository {
    List<Department> findAll();

    List<Department> findByDepartmentName(String name);

    boolean deleteDepartmentByName(String name);

    boolean updateDepById(int departmentId, String name);
}
