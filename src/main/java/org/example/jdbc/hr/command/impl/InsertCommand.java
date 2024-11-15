package org.example.jdbc.hr.command.impl;

import org.example.jdbc.hr.command.Command;
import org.example.jdbc.hr.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/***
 * 插入数据
 *
 * @author Swei
 * @description
 * @date 2024/11/6 15:05
 **/
public class InsertCommand implements Command {
    @Override
    public void execute() {
        Connection connection = null;
        PreparedStatement ps = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter eno: ");
        Integer eno = scan.nextInt();
        System.out.println("Enter ename: ");
        String name = scan.next();
        System.out.println("Enter salary: ");
        Float salary = scan.nextFloat();
        System.out.println("Enter dname: ");
        String dname = scan.next();
        try {
            connection = DbUtils.getConnection();
            String insert = "insert into  employee(eno,ename,salary,dname) values(?,?,?,?)";
            ps = connection.prepareStatement(insert);
            ps.setInt(1, eno);
            ps.setString(2, name);
            ps.setFloat(3, salary);
            ps.setString(4, dname);
//            所有写的操作都是executeUpdate
//            executeUpdate返回记录数
            int count = ps.executeUpdate();
            System.out.println("插入" + count + "条数成功！");
            System.out.println(name + "员工入职成功！");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeConnection(null, ps, connection);
        }
    }
}
