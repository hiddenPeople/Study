package org.example.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.example.jdbc.hr.common.DbUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/***
 * Druid连接池的配置与使用
 *
 * @author Swei
 * @description
 * @date 2024/11/7 14:51
 **/
public class DruidSample {
    public static void main(String[] args) {
//        加载属性文件
        Properties props = new Properties();
//        用来获取reosurces下文件路径
        String propertiesFile = DruidSample.class.getResource("/druid-config.properties").getPath();
        try {
//            解决属性文件地址中的中文乱码问题，比如空格等字符转码的问题
            propertiesFile = URLDecoder.decode(propertiesFile, "UTF-8");
            props.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        ;
        ResultSet rs = null;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
            conn = dataSource.getConnection();
            String insertsql = "insert into employee(eno,ename,salary,dname) values(?,?,?,?)";
            stmt = conn.prepareStatement(insertsql);
            stmt.setInt(1, 2);
            stmt.setString(2, "Swei");
            stmt.setFloat(3, 5000);
            stmt.setString(4, "IT");
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeConnection(rs, stmt, conn);
        }
    }
}
