package application.service;


import application.entity.ReqSwitch;
import application.model.TimeOnEntity;
import application.repository.TimeOnRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShedulerService {

    private final TimeOnRepository timeOnRepository;
    private static final String CRON = "*/10 * * * * *";

    @Scheduled(cron = CRON)
    public void on(){
        LocalDateTime localDateTime=LocalDateTime.now();

        int h=localDateTime.getHour();
        int  m=localDateTime.getMinute();
       List<TimeOnEntity> list= timeOnRepository.findByHourAndMinute(h,m);
        if (!list.isEmpty())
            list.forEach(time -> {
                try {
                    System.out.println("совпало");
                    ReqSwitch reqSwitch=new ReqSwitch();
                    reqSwitch.setDeviceid("room");
                    reqSwitch.data.put("switch", "on");


                    RestTemplate restTemplate = new RestTemplate();
                    Object response = restTemplate.postForObject("http://192.168.0.171:8081/zeroconf/switch" , reqSwitch, Object.class
                    );
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);

                    System.out.println(response);
                }catch(Exception e){
                    System.out.println("что-то не так");
                }});
            }

}

