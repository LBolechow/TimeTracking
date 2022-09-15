package pl.lukbol.TimeTracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukbol.TimeTracking.models.Workday;

public interface WorkdayRepository extends JpaRepository<Workday, Long> {

}