package work.lemoon.demo.springboottest.service.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lemoon.demo.springboottest.service.CountingService;

import java.util.Arrays;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private CountingService countingService;

    @Override
    public PaymentResult pay(PaymentRequest request) {
        int cnt = countingService.count(Arrays.asList(request.getData().split(",")));
        return new PaymentResult(cnt);
    }
}
