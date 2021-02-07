package application.entity;

import application.model.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDevice {
    public List<DeviceEntity> devices;
}
