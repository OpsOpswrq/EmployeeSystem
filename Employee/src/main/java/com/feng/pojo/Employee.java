package com.feng.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;  // 0 为女   1 为男
    private Department department;
    private Date birth;

    public Employee(int id, String name, String email, int gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
