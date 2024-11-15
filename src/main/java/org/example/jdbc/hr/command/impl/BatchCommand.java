package org.example.jdbc.hr.command.impl;

import org.example.jdbc.hr.command.Command;
import org.example.jdbc.hr.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/***
 * 批处理新增方法
 *
 * @author Swei
 * @description
 * @date 2024/11/7 09:47
 **/
public class BatchCommand implements Command {
    @Override
    public void execute() {
        Connection connection = null;
        PreparedStatement ps = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new java.util.Date());
        long lTime = System.currentTimeMillis();
        lTime = new java.util.Date().getTime();
        java.sql.Date dtime = new java.sql.Date(lTime);
        try {
            connection = DbUtils.getConnection();
            connection.setAutoCommit(false);
//            String insert = "insert into  employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
            String insert = "delete from employee where eno = ?";
            ps = connection.prepareStatement(insert);
            for (int i = 10000; i < 20000; i++) {
                ps.setInt(1, 10000 + i);
                ps.addBatch();
            }
//            所有写的操作都是executeUpdate
//            executeUpdate返回记录数
            int[] arrays = ps.executeBatch();
            long endTime = System.currentTimeMillis();
            connection.commit();
            System.out.println("程序运行时间： " + (endTime - lTime) + "ms");
        } catch (ClassNotFoundException | SQLException e) {
            try {
                if (connection != null || !connection.isClosed())
                    connection.rollback();
            } catch (SQLException ex) {
                ex.initCause(e);
                throw new RuntimeException(ex);
            }
        } finally {
            DbUtils.closeConnection(null, ps, connection);
        }
    }
}
