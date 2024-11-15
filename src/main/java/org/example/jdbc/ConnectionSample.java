package org.example.jdbc;

import java.sql.*;

/***
 * jdbc创建Connection链接
 *
 * @author Swei
 * @description 对Mysql数据库进行连接
 * @project jdbc-sample
 * @date 2024/11/6 09:16
 **/
public class ConnectionSample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
//                加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimeZone=Asia/Shanghai&allowPublicKeyRetrieval=true";
            String user = "test";
            String password = "123456";
//                创建数据库连接
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
//                创建Statement对象
            stmt = connection.createStatement();
//                获取结果集
            rs = stmt.executeQuery("select * from employee");
//                遍历结果
//                rs.next()返回布尔值，代表是否存在下一条记录
//                如果有下一条记录，返回true，同时结果集就会提取下一条记录
//                如果没有，则返回false，并结束循环
            while (rs.next()) {
//                    JDBC字段索引是从1开始，而并非从0开始
                Integer eno = rs.getInt(1);
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
//            关闭连接，释放资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

//            原则上只需要关闭connection，因为Statement和ResultSet都是通过Connection创建的。
//            关闭了物理连接，所以其他连接也就自动被释放了
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
