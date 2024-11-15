package org.example.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.twelvemonkeys.lang.StringUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.jdbc.hr.common.DbUtils;
import org.example.jdbc.hr.entity.Employee;

import javax.sql.DataSource;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/***
 * Apache DBUtils + Durid联合使用演示
 *
 * @author Swei
 * @description
 * @date 2024/11/8 10:11
 **/
public class DbUtilSample {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String propertyName;
        propertyName = Objects.requireNonNull(DbUtilSample.class.getResource("/druid-config.properties")).getPath();
        Connection connection = null;
        try {
            if (StringUtil.isEmpty(propertyName)) {
                return;
            }
            propertyName = URLDecoder.decode(propertyName, "UTF-8");
            properties.load(Files.newInputStream(Paths.get(propertyName)));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            String updSql = "update ignore employee set ename = ? where eno = ?";
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            QueryRunner qr1 = new QueryRunner();
            qr1.update(connection, updSql, "测试员工0002", 2);
            connection.commit();

//            在使用查询时是需要将数据库连接池作为参数传入
            QueryRunner qr = new QueryRunner(dataSource);
            List<Employee> list = (List<Employee>) qr.query("select * from employee limit ?,10", new BeanListHandler(Employee.class),
                    new Object[]{0});
            for (Employee e : list) {
                System.out.println(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeConnection(null, null, connection);
        }
    }

}
