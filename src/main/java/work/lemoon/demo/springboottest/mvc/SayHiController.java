package work.lemoon.demo.springboottest.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.lemoon.demo.springboottest.base.WrapResult;
import work.lemoon.demo.springboottest.service.CountingService;
import work.lemoon.demo.springboottest.service.pay.PaymentRequest;
import work.lemoon.demo.springboottest.service.pay.PaymentResult;
import work.lemoon.demo.springboottest.service.pay.PaymentService;

import java.util.Arrays;

@RestController
@RequestMapping("/say")
public class SayHiController {
    private final static Logger log = LoggerFactory.getLogger(SayHiController.class);

    @Autowired
    private CountingService countingService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/count")
    @WrapResult
    String doCount(@RequestParam("data") String data) {
        log.info("received: {}", data);

        int r = countingService.count(Arrays.asList(data.split(",")));

        return wrap(r);
    }

    @GetMapping("/pay")
    String doPay(@RequestParam("data") String data) {
        log.info("received: {}", data);

        PaymentRequest request = new PaymentRequest();
        request.setData(data);
        PaymentResult result = paymentService.pay(request);

        return wrap(result.getCount());
    }

    private String wrap(int r) {
        return String.format("[%d]", r);
    }
}
