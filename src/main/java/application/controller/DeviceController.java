package application.controller;


import application.model.DeviceEntity;
import application.repository.DeviceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<DeviceEntity> GetDevices() {
        return deviceEntityRepository.findAll();
    }

    @PostMapping(value = "/p", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeviceEntity AddUser(@RequestBody DeviceEntity deviceEntity) {
        DeviceEntity dE = new DeviceEntity();
        Integer ip = deviceEntity.getIp();
        dE.setIp(ip);




        return DeviceEntityRepository.save(dE);
    }

}