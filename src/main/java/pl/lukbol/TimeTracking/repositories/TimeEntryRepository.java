package pl.lukbol.TimeTracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukbol.TimeTracking.models.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

}
