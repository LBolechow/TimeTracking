package pl.lukbol.TimeTracking.controllers;


import org.springframework.web.bind.annotation.*;
import pl.lukbol.TimeTracking.models.TimeEntry;
import pl.lukbol.TimeTracking.models.Workday;
import pl.lukbol.TimeTracking.exceptions.WorkdayNotFoundException;
import pl.lukbol.TimeTracking.repositories.TimeEntryRepository;
import pl.lukbol.TimeTracking.repositories.WorkdayRepository;

import java.util.List;

@RestController
public class TimeEntryController {
    private final WorkdayRepository workdayRepository;
    private final TimeEntryRepository entryRepository;

    TimeEntryController(WorkdayRepository workdayRepository, TimeEntryRepository entryRepository) {
        this.workdayRepository = workdayRepository;
        this.entryRepository = entryRepository;
    }

    @GetMapping("/workdays/{id}/entries")
    List<TimeEntry> getEntries(@PathVariable Long id) {
        Workday workDay = workdayRepository.findById(id) //
                .orElseThrow(() -> new WorkdayNotFoundException(id));
        return  workDay.getTimeEntry();

    }

    @PostMapping("/workdays/{id}/entries")
    void postEntries(@RequestBody TimeEntry entry, @PathVariable Long id) {
        Workday workDay = workdayRepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
     TimeEntry timeEntry = new TimeEntry(entry.opis, entry.czas);
     timeEntry.setWorkday(workDay);
     workDay.getTimeEntry().add(timeEntry);
        workdayRepository.save(workDay);

    }





}
