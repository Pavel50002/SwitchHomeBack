package application.model;


import lombok.*;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "device_table")
@Data
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    public String ip;

    @Column
    public String room;
    @Column
    public String description;

    @Column
    public long how_much_to_work;

    public boolean isIs_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

    @Column
    public boolean is_online;

    @Column
    public  Date date;



}
