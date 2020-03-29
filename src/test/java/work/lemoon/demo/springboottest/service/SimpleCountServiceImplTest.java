package work.lemoon.demo.springboottest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class SimpleCountServiceImplTest {

    @MockBean
    private CountingService countingService;

    @Test
    public void testCount() {
        given(countingService.count(any(Collection.class))).willReturn(3);
        int cnt = countingService.count(Arrays.asList(1, 2, 3));
        assertEquals(3, cnt);
    }
}