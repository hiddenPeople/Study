package org.example.jdbc.hr.command.impl;

import org.example.jdbc.hr.command.Command;
import org.example.jdbc.hr.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/7 14:27
 **/
public class DeleteCommand implements Command {
    @Override
    public void execute() {
        {
            Connection connection = null;
            PreparedStatement ps = null;
            long startTime = System.currentTimeMillis();
            try {
                connection = DbUtils.getConnection();
                String insert = "delete from employee  where eno >= ? and eno < ?";
                ps = connection.prepareStatement(insert);
                ps.setInt(1, 10000);
                ps.setInt(2, 20000);
//            所有写的操作都是executeUpdate
//            executeUpdate返回记录数
                int count = ps.executeUpdate();
                long endTime = System.currentTimeMillis();
                System.out.println("删除" + count + "条数成功！");
                System.out.println("耗时：" + (endTime - startTime) + "ms");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DbUtils.closeConnection(null, ps, connection);
            }
        }
    }
}
