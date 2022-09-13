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
    List<TimeEntry> k(@PathVariable Long id) {
        Workday WorkDay = Workdayrepository.findById(id) //
                .orElseThrow(() -> new WorkdayNotFoundException(id));
        return WorkDay.getTimeEntry();

    }

    @PostMapping("/workdays/{id}/entries")
    void e(@RequestBody TimeEntry entry, @PathVariable Long id) {
        Workday WorkDay = Workdayrepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
        WorkDay.getTimeEntry().add(new TimeEntry(entry.opis, entry.czas));

        TimeEntry TimeEntry = Workdayrepository.findById(id).map(workday -> {
            entry.setWorkday(workday);
            return TimeEntryrepository.save(entry);
        }).orElseThrow(() -> new WorkdayNotFoundException(id));
    }





}
