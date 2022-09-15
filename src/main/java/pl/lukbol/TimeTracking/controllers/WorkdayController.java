package pl.lukbol.TimeTracking.controllers;


import org.springframework.web.bind.annotation.*;
import pl.lukbol.TimeTracking.repositories.TimeEntryRepository;
import pl.lukbol.TimeTracking.models.Workday;
import pl.lukbol.TimeTracking.exceptions.WorkdayNotFoundException;
import pl.lukbol.TimeTracking.repositories.WorkdayRepository;

import java.util.List;

@RestController
public class WorkdayController {

    public final WorkdayRepository workdayRepository;
    public final TimeEntryRepository entryRepository;

    WorkdayController(WorkdayRepository workdayRepository, TimeEntryRepository entryRepository) {
        this.workdayRepository = workdayRepository;
        this.entryRepository = entryRepository;
    }
    @GetMapping("/workdays")
    List<Workday> all() {
        return workdayRepository.findAll();
    }

    @PostMapping("/workdays")
    Workday AddNewWorkday(@RequestBody Workday newWorkday) {
        return workdayRepository.save(newWorkday);
    }

    @GetMapping("/workdays/{id}")
    Workday GetWorkdayById(@PathVariable Long id) {

        return workdayRepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
    }

    @PutMapping("/workdays/{id}")
    Workday ReplaceWorkdayById(@RequestBody Workday newWorkday, @PathVariable Long id) {

        return workdayRepository.findById(id)
                .map(workDay -> {
                    workDay .setDate(newWorkday.getDate());
                    return workdayRepository.save(workDay );
                })
                .orElseGet(() -> {
                    newWorkday.setId(id);
                    return workdayRepository.save(newWorkday);
                });
    }

    @DeleteMapping("/workdays/{id}")
    void DeleteWorkdayById(@PathVariable Long id) {
        workdayRepository.deleteById(id);
    }


}
