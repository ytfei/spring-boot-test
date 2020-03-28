package work.lemoon.demo.springboottest.mvc;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import work.lemoon.demo.springboottest.service.CountingService;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 通过替换底层的服务实现，来实现对中间逻辑层的测试
 */
@SpringBootTest(classes = SayHiControllerTest2.Conf.class)
@AutoConfigureMockMvc
class SayHiControllerTest2 {

    @TestConfiguration
    public static class Conf {

        @Bean
        @Primary
        CountingService countingService() {
            CountingService cs = Mockito.mock(CountingService.class);
            given(cs.count(any(Collection.class))).willReturn(100);

            return cs;
        }
    }

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CountingService countingService;

    @Test
    public void testPay() throws Exception {
        assertEquals(100, countingService.count(Arrays.asList(1, 2, 3)));
        mvc.perform(get("/say/pay?data=1,2,3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("[100]"));
    }
}