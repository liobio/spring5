import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName JdbcTemplateTest.java
 * @createTime 2021/08/02/12:55:00
 * @Description
 */
public class JdbcTemplateTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc1.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = bean.getConnection();

        System.out.println(connection);
        System.out.println(jdbcTemplate);


        String sql="INSERT INTO `mytest`.`user-info` (`UserId`, `UserName`, `UserSex`) VALUES (?, ?, ?);";
        int out= jdbcTemplate.update(sql,3,"usa","男");
        System.out.println(out);


    }
}
