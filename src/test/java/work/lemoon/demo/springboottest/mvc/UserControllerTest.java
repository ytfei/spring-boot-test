package work.lemoon.demo.springboottest.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import work.lemoon.demo.springboottest.mapper.UserMapper;
import work.lemoon.demo.springboottest.service.dto.User;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, MybatisAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext context;

    @MockBean
    private UserMapper userMapper;

//    @Test
//    void excludeMybatisAutoConfig() {
//        assertNull(context.getBean(User2Mapper.class));
//    }

    @Test
    void count() throws Exception {
        given(userMapper.countUser()).willReturn(10);

        mvc.perform(get("/user/count").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("110"));
    }

    @Test
    void add() throws Exception {
        given(userMapper.addUser(any(User.class))).willReturn(10);

        mvc.perform(get("/user/add?name=hi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("210"));
    }
}