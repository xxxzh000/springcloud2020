package springcloud.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class OrderController {

    //服务地址 8004暴露出来的名字
    public static final String INVOK_URL="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentinfo(){
        String forObject = restTemplate.getForObject(INVOK_URL + "/payment/consul", String.class);
        return  forObject;
    }
}
