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
        Workday Workday = Workdayrepository.findById(id) //
                .orElseThrow(() -> new WorkdayNotFoundException(id));
        return  Workday.getTimeEntry();

    }

    @PostMapping("/workdays/{id}/entries")
    void e(@RequestBody TimeEntry entry, @PathVariable Long id) {
        Workday workDay = Workdayrepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
     TimeEntry timeEntry = new TimeEntry(entry.opis, entry.czas);
     timeEntry.setWorkday(workDay);
     workDay.getTimeEntry().add(timeEntry);
     Workdayrepository.save(workDay);

    }





}
