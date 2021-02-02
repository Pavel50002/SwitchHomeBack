package application.model;


import lombok.*;

import javax.persistence.*;
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
    private Integer id;
    @Column
    private Integer ip;

    @Column
    private String room;
    @Column
    private String description;

    @Column
    private int how_much_to_work;

    @Column
    private boolean is_online;
}
