package work.lemoon.demo.springboottest.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.lemoon.demo.springboottest.service.dto.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tengfei Yang 3/31/20
 **/
@SpringBootTest
class UserPlusMapperTest {
    @Autowired
    private UserPlusMapper userPlusMapper;

    @Test
    void countUser2() {
        User u = new User();
        u.setName("asdf");

        int i = userPlusMapper.insert(u);
        assertEquals(1, i);

        int j = userPlusMapper.selectCount(null);
        assertEquals(1, j);

        User u2 = userPlusMapper.selectOne(null);
        assertEquals(u.getName(), u2.getName());

        // 因为事务不同，且事务在测试后回滚，所以这个使用场景略有不同，可以用于测试初始化的配置数据断言
//        Table table = new Table(dataSource, "user");
//        assertThat(table).hasNumberOfRows(1);

        Page<?> page = new Page<>(1, 3);
        IPage<User> userIPage = userPlusMapper.selectByPage(page);
        assertEquals(1, userIPage.getSize());
    }
}