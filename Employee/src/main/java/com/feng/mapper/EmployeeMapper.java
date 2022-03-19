package com.feng.mapper;

import com.feng.pojo.Department;
import com.feng.pojo.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Component
public class EmployeeMapper {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentMapper departmentMapper;
    static {
        employees = new HashMap<>();
        employees.put(101,new Employee(101,"AA","A2560965468@qq.com",0,new Department(101,"教学部")));
        employees.put(102,new Employee(102,"BB","B2560965468@qq.com",1,new Department(102,"市场部")));
        employees.put(103,new Employee(103,"CC","C2560965468@qq.com",0,new Department(103,"校研部")));
        employees.put(104,new Employee(104,"DD","D2560965468@qq.com",1,new Department(104,"运营部")));
        employees.put(105,new Employee(105,"EE","E2560965468@qq.com",0,new Department(105,"后勤部")));
    }
    private static int initId = 106;
    public void addEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(),employee);
    }
    public Collection<Employee> getALlEmployees(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
}
