package ee.bcs.valiit.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Component
public class ScheduledTasks {

//    @Scheduled(fixedDelay = 5000)
    public void test(){
        System.out.println("test");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("https://api.binance.com/api/v3/klines?symbol=BTCUSDT&interval=1h&startTime=1638813600000", List.class);
        List elements = responseEntity.getBody();
        for (Object element : elements) {
            List sublist = (List) element;
            System.out.println(sublist.get(0) + ": " + sublist.get(4));
        }
        /*
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SampleEmployeeDto[]> a = restTemplate.getForEntity("http://localhost:8080/sql-test4",
                SampleEmployeeDto[].class);
        System.out.println(Arrays.toString(a.getBody()));
        ResponseEntity<String> b = restTemplate.getForEntity("http://localhost:8080/sql-test4", String.class);
        System.out.println(b.getBody());*/
    }
}
