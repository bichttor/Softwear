package com.softwears.Softwear.Users;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee getEmployeeId(int id){
        return repo.findById(id).orElse(new Employee());
    }   

    public void addEmployee(Employee employee){
        repo.save(employee);
    }

    public void updateEmployee(Employee employee){
        repo.save(employee);
    }

    public void deleteEmployee(int id){
        repo.deleteById(id);
    }
}
