package com.feng.controller;

import com.feng.mapper.DepartmentMapper;
import com.feng.mapper.EmployeeMapper;
import com.feng.pojo.Department;
import com.feng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class empController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @RequestMapping("/emps")
    public String getAllEmployees(Model model){
        Collection<Employee> aLlEmployees = employeeMapper.getALlEmployees();
        model.addAttribute("emps",aLlEmployees);
        return "emps/list";
    }
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> department = departmentMapper.getALlDepartments();
        model.addAttribute("departments",department);
        return "emps/addEmp";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/toUpdate/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> aLlDepartments = departmentMapper.getALlDepartments();
        model.addAttribute("departments",aLlDepartments);
        return "emps/updateEmp";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/deleteEmp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
