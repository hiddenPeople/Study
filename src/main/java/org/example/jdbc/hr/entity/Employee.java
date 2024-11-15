package org.example.jdbc.hr.entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import java.util.Date;

/***
 * 员工表实体类
 *
 * @author Swei
 * @description
 * @date 2024/11/7 09:44
 **/

@Data
public class Employee {
    private Integer eno;

    private String ename;

    private Float salary;

    private String dname;

    private Date hiredate;

    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", dname='" + dname + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
