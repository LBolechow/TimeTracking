package pl.lukbol.TimeTracking.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukbol.TimeTracking.service.TimeEntryService;
import pl.lukbol.TimeTracking.models.TimeEntry;


import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    private TimeEntryService timeEntryService;


    @GetMapping("/workdays/{id}/entries")
    List<TimeEntry> getEntries(@PathVariable Long id) {
        return  timeEntryService.getEntries(id);

    }

    @PostMapping("/workdays/{id}/entries")
    void postEntries(@RequestBody TimeEntry entry, @PathVariable Long id) {
   timeEntryService.postEntries(entry, id);

    }





}
