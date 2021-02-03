package application.repository;

import application.model.DeviceEntity;
import application.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceEntityRepository extends JpaRepository<DeviceEntity, Integer> {

//        DeviceEntity findById(Integer id);
    }

