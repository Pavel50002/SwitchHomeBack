package application.repository;

import application.model.DeviceEntity;
import application.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceEntityRepository extends JpaRepository<DeviceEntity, Integer> {

  //  public void deleteById(Integer id);
     //  DeviceEntity findById(Integer id);
    }

