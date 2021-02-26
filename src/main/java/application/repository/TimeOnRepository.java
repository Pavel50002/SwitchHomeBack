package application.repository;

import application.model.TimeOnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeOnRepository extends JpaRepository<TimeOnEntity,Integer> {

    List<TimeOnEntity> findByHourAndMinute(int hour, int minute);

}
