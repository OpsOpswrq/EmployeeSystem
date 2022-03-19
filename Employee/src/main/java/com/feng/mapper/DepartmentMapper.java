package com.feng.mapper;

import com.feng.pojo.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Component
public class DepartmentMapper {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"校研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }
    public Collection<Department> getALlDepartments(){
        return departments.values();
    }
    public Department getDepartmentById(int id){
        return departments.get(id);
    }
}
