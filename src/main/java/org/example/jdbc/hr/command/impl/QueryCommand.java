package org.example.jdbc.hr.command.impl;

import org.example.jdbc.hr.command.Command;
import org.example.jdbc.hr.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/6 15:15
 **/
public class QueryCommand implements Command {

    /***
     * 查询数据
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/6 15:23
     * @return void
     */
    @Override
    public void execute() {
        String sql = "select * from employee";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("员工编号：" + rs.getInt("eno") + "，员工姓名：" + rs.getString("ename") + "，员工薪资：" + rs.getFloat("salary") + "，员工部门：" + rs.getString("dname"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeConnection(rs, ps, conn);
        }
    }
}
