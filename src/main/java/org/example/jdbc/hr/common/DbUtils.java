package org.example.jdbc.hr.common;

import java.sql.*;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/6 15:00
 **/
public class DbUtils {

    /***
     * 注册并创建数据库的连接
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/6 15:04
     * @return java.sql.Connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimeZone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String user = "test";
        String password = "123456";
//                创建数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /***
     * 关闭所有的连接
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/6 15:04
     * @return void
     */
    public static void closeConnection(ResultSet rs, Statement stmt, Connection connection) {
//        关闭连接，释放资源
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
