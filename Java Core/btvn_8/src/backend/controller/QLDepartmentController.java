package backend.controller;

import backend.IQLDepartment;
import backend.service.IQLDepartmentService;
import backend.service.impl.QLDepartmentServiceImpl;
import entity.Account;
import entity.Department;

import java.util.List;

public class QLDepartmentController {
    private IQLDepartmentService departmentService;

public QLDepartmentController() {
    departmentService = new QLDepartmentServiceImpl();
}


    public List<Department> findAll() {
    return departmentService.findAll();
    }

    public List<Department> findByDepartmentName(String name) {
        return departmentService.findByDepartmentName(name);
    }

    public boolean deleteDepartmentByName(String name) {
        return departmentService.deleteDepartmentByName(name);
    }

    public boolean updateDepById(int departmentId, String name) {
    return departmentService.updateDepById(departmentId, name);
    }



}
