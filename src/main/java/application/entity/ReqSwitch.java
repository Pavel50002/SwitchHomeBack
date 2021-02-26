package application.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@Data
public class ReqSwitch {

    private String deviceid;
    public Map<String, Object> data = new HashMap<String, Object>();
}
