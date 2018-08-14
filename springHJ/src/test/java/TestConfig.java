import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @author Charles on 2018/5/15.
 */
public class TestConfig {
    private static ApplicationContext ctx ;
    static {
        // 通过静态代码块的方式,让程序加载spring的配置文件
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     * 测试spring容器是否实例化了数据源 。如果实例化了，说明Spring容器整合没问题
     *
     * @throws SQLException
     */
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println("数据源："+ dataSource);
        System.out.println("连接："+ dataSource.getConnection());
    }
}
