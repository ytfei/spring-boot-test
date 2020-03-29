package work.lemoon.demo.springboottest.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import work.lemoon.demo.springboottest.service.CountingService;
import work.lemoon.demo.springboottest.service.pay.PaymentService;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 除了初始化 Web Controller 相关的资源，其它的 Service 都不会初始化，如果 Controller 依赖到这些资源，必须使用 @MockBean
 * <p>
 * 所以 WebMvcTest 主要用于测试 Controller 的逻辑
 */
@WebMvcTest(SayHiController.class)
class SayHiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountingService countingService;

    @MockBean
    private PaymentService paymentService;

    @Test
    void doCount() throws Exception {
        given(countingService.count(any(Collection.class))).willReturn(100);

        assertEquals(100, countingService.count(Arrays.asList(1, 2, 3)));

        mvc.perform(get("/say/count?data=1,2,3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("[100]"));
    }
}