package work.lemoon.demo.springboottest.mapper;

import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import work.lemoon.demo.springboottest.dao.UserDao;
import work.lemoon.demo.springboottest.service.dto.User;

import javax.sql.DataSource;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 通过 MyBatisTest 来验证对 Dao 层的逻辑测试
 * <p>
 * Tengfei Yang 3/29/20
 **/
@MybatisTest /* 这个注解会替换配置文件中声明的数据源，使用一个内存数据库来做测试 */
// 该注解表示不要使用 @MyBatisTest 声明的内存数据库，而是使用系统配置的数据库
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserDao.class)
// 如果 Mapper 类上面没有加 @Mapper 注解，则需要增加 @MapperScan
@MapperScan("work.lemoon.demo.springboottest.mapper")
class UserMapperTest {

    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    @Test
    void countUser() {
        User u = new User();
        u.setName("asdf");

        int i = user2Mapper.addUser(u);
        assertEquals(1, i);

        int j = userDao.countUser();
        assertEquals(101, j);

        User u2 = user2Mapper.selectOne(1L);
        assertEquals(u.getName(), u2.getName());

        // 因为事务不同，且事务在测试后回滚，所以这个使用场景略有不同，可以用于测试初始化的配置数据断言
//        Table table = new Table(dataSource, "user");
//        assertThat(table).hasNumberOfRows(1);
    }

    @Test
    void addUser() {

    }
}