package pl.lukbol.TimeTracking;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private final WorkdayRepository Workdayrepository;
    private final TimeEntryRepository TimeEntryrepository;

    TimeEntryController(WorkdayRepository Workdayrepository, TimeEntryRepository TimeEntryrepository) {
        this.Workdayrepository = Workdayrepository;
        this.TimeEntryrepository = TimeEntryrepository;
    }
    @GetMapping("/workdays/{id}/entries")
    List<TimeEntry> all() {
        return TimeEntryrepository.findAll();
    }

    @PostMapping("/workdays/{id}/entries")
    TimeEntry newTimeEntry(@RequestBody TimeEntry newTimeEntry) {
        return TimeEntryrepository.save(newTimeEntry);
    }
    @GetMapping("/workdays/{id}/entries/{id2}")
    TimeEntry one(@PathVariable Long id2) {

        return TimeEntryrepository.findById(id2)
                .orElseThrow(() -> new TimeEntryNotFoundException(id2));
    }
    @PutMapping("/workdays/{id}/entries/{id2}")
    TimeEntry replaceTimeEntry(@RequestBody  TimeEntry newTimeEntry, @PathVariable Long id2) {

        return TimeEntryrepository.findById(id2)
                .map(timeentry -> {
                    timeentry.setOpis(newTimeEntry.getOpis());
                    timeentry.setCzas(newTimeEntry.getCzas());
                    return TimeEntryrepository.save(timeentry);
                })
                .orElseGet(() -> {
                    newTimeEntry.setId(id2);
                    return TimeEntryrepository.save(newTimeEntry);
                });
    }
    @DeleteMapping("/workdays/{id}/entries/{id2}")
    void deleteTimeEntry(@PathVariable Long id2) {
        TimeEntryrepository.deleteById(id2);
    }


}