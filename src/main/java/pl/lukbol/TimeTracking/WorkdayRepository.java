package pl.lukbol.TimeTracking;

import org.springframework.data.jpa.repository.JpaRepository;

interface WorkdayRepository extends JpaRepository<Workday, Long> {

}