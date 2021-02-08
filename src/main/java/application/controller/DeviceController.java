package application.controller;


import application.entity.ResponseData;
import application.entity.ResponseDevice;
import application.model.DeviceEntity;
import application.repository.DeviceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private final DeviceEntityRepository deviceEntityRepository;

    public DeviceController(DeviceEntityRepository deviceEntityRepository) {
        this.deviceEntityRepository = deviceEntityRepository;
    }


    //all device
    @GetMapping(value = "/alldevice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData GetDevices() {
//ResponseData responseData=new ResponseData();

        List<DeviceEntity> entities = deviceEntityRepository.findAll();
        ResponseDevice device = new ResponseDevice(entities);
        ResponseData responseData=new ResponseData(device);


//        return new ResponseData(new ResponseDevice(deviceEntityRepository.findAll()));
        return responseData;
       // return responseData;
    }

    @PostMapping(value = "/device", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeviceEntity AddDevice(@RequestBody DeviceEntity deviceEntity) {
        DeviceEntity deviceEntity1 = new DeviceEntity();

        String ip = deviceEntity.getIp();
        deviceEntity1.setIp(ip);

        String room =deviceEntity.getRoom();
        deviceEntity1.setRoom(room);

        String description=deviceEntity.getDescription();
        deviceEntity1.setDescription(description);

        int time=deviceEntity.getHow_much_to_work();
        deviceEntity1.setHow_much_to_work(time);

        boolean isOnline=deviceEntity.isIs_online();
        deviceEntity1.setIs_online(isOnline);

        return deviceEntityRepository.save(deviceEntity1);
    }

    //Удаление по айди
    @CrossOrigin
    @DeleteMapping(value = "deldevice", produces = MediaType.APPLICATION_JSON_VALUE)
    //@Transactional
    public List DeleteDevice(@RequestParam(name = "id")Integer dev_id){
//        zahodRep.deleteById(user_id);
        deviceEntityRepository.deleteById(dev_id);
        String resp="\"id_delete\":" + dev_id;
        List list=new LinkedList<>();
        list.add(resp);
        list.add(deviceEntityRepository.findAll());
        return list;
    }



}
