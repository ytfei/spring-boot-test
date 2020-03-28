package work.lemoon.demo.springboottest.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import work.lemoon.demo.springboottest.service.CountingService;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 通过替换底层的服务实现，来实现对中间逻辑层的测试：直接使用 MockBean 就能替换底层逻辑了
 */
@SpringBootTest
@AutoConfigureMockMvc
class SayHiControllerTest3 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountingService countingService;

    @Test
    public void testPay() throws Exception {
        given(countingService.count(any(Collection.class))).willReturn(100);

        assertEquals(100, countingService.count(Arrays.asList(1, 2, 3)));
        mvc.perform(get("/say/pay?data=1,2,3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("[100]"));
    }
}