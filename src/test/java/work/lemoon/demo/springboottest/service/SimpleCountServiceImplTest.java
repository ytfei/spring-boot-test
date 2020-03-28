package work.lemoon.demo.springboottest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleCountServiceImplTest {

    @MockBean
    private CountingService countingService;

    @Test
    public void testCount() {
        int cnt = countingService.count(Arrays.asList(1, 2, 3));
        assertEquals(3, cnt);
    }
}