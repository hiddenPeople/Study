package org.example.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.example.jdbc.hr.common.DbUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * C3P0连接池的配置与使用
 *
 * @author Swei
 * @description
 * @date 2024/11/8 09:26
 **/
public class C3P0Sample {
    public static void main(String[] args) {
//        加载配置文件
//        配置DataSource
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from employee limit 0,10");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ename"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeConnection(resultSet, statement, connection);
        }
    }
}
