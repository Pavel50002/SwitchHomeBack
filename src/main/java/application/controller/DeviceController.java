package application.controller;


import application.entity.ResponseData;
import application.entity.ResponseDevice;
import application.model.DeviceEntity;
import application.model.TimeOnEntity;
import application.repository.DeviceEntityRepository;
import application.repository.TimeOnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class DeviceController {

    @Autowired

    private final DeviceEntityRepository deviceEntityRepository;

    public DeviceController(DeviceEntityRepository deviceEntityRepository, TimeOnRepository timeOnRepository) {
        this.deviceEntityRepository = deviceEntityRepository;
        this.timeOnRepository = timeOnRepository;
    }


    @Autowired
    private final TimeOnRepository timeOnRepository;
   /* public DeviceController(TimeOnRepository timeOnRepository) {
        this.timeOnRepository = timeOnRepository;
    }*/





    //all device
    @GetMapping(value = "/alldevice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData GetDevices() {
//ResponseData responseData=new ResponseData();

        List<DeviceEntity> entities = deviceEntityRepository.findAll();
        ResponseDevice device = new ResponseDevice(entities);
        ResponseData responseData = new ResponseData(device);


//        return new ResponseData(new ResponseDevice(deviceEntityRepository.findAll()));
        return responseData;
        // return responseData;
    }

    @PostMapping(value = "/device", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeviceEntity AddDevice(@RequestBody DeviceEntity deviceEntity) {
        DeviceEntity deviceEntity1 = new DeviceEntity();

        String ip = deviceEntity.getIp();
        deviceEntity1.setIp(ip);

        String room = deviceEntity.getRoom();
        deviceEntity1.setRoom(room);

        String description = deviceEntity.getDescription();
        deviceEntity1.setDescription(description);

        long time = deviceEntity.getHow_much_to_work();
        deviceEntity1.setHow_much_to_work(time);

        boolean isOnline = deviceEntity.isIs_online();
        deviceEntity1.setIs_online(isOnline);

        Date date = deviceEntity.getDate();
        deviceEntity1.setDate(date);

        return deviceEntityRepository.save(deviceEntity1);
    }

    //Удаление по айди
    @CrossOrigin
    @DeleteMapping(value = "deldevice", produces = MediaType.APPLICATION_JSON_VALUE)
    //@Transactional
    public List DeleteDevice(@RequestParam(name = "id") Integer dev_id) {
//        zahodRep.deleteById(user_id);
        deviceEntityRepository.deleteById(dev_id);
        String resp = "\"id_delete\":" + dev_id;
        List list = new LinkedList<>();
        list.add(resp);
        list.add(deviceEntityRepository.findAll());
        return list;
    }

    //Редактирование
    @PutMapping(value = "updatedevice", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeviceEntity PutDevice(@RequestParam(name = "id") Integer dev_id, @RequestBody DeviceEntity deviceEntity) {
        DeviceEntity deviceEntity1 = deviceEntityRepository.findById(dev_id).get();

        String ip = deviceEntity.getIp();
        if(ip!=null){
        deviceEntity1.setIp(ip);}

        String room = deviceEntity.getRoom();
        if(room!=null)
        deviceEntity1.setRoom(room);

        String description = deviceEntity.getDescription();
        if(description!=null)
        deviceEntity1.setDescription(description);

        long time = deviceEntity.getHow_much_to_work();
        if(time!=0)
        deviceEntity1.setHow_much_to_work(time);

        boolean isOnline = deviceEntity.isIs_online();
        if(ip!=null)
        deviceEntity1.setIs_online(isOnline);

        Date date = deviceEntity.getDate();
        if(ip!=null)
        deviceEntity1.setDate(date);
        return deviceEntityRepository.save(deviceEntity1);
    }


    @PostMapping(value = "/on", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeOnEntity AddDevice(@RequestBody TimeOnEntity timeOnEntity) {
        TimeOnEntity timeOnEntity1= new TimeOnEntity();
        int hour = timeOnEntity.getHour();
        timeOnEntity1.setHour(hour);

        int minute =timeOnEntity.getMinute();
        timeOnEntity1.setMinute(minute);

        return timeOnRepository.save(timeOnEntity1);
    }


}
