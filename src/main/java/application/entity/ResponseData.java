package application.entity;


import application.model.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseData {
    public ResponseDevice data;
}
/*@Data
public class ResponseData {
    private List<DeviceEntity> devices;
}*/
