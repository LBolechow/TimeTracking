package pl.lukbol.TimeTracking;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class WorkdayController {

    private final WorkdayRepository Workdayrepository;
    private final TimeEntryRepository TimeEntryrepository;

    WorkdayController(WorkdayRepository Workdayrepository, TimeEntryRepository TimeEntryrepository) {
        this.Workdayrepository = Workdayrepository;
        this.TimeEntryrepository = TimeEntryrepository;
    }
    @GetMapping("/workdays")
    List<Workday> all() {
        return Workdayrepository.findAll();
    }

    @PostMapping("/workdays")
    Workday newWorkday(@RequestBody Workday newWorkday) {
        return Workdayrepository.save(newWorkday);
    }
    @GetMapping("/workdays/{id}")
    Workday one(@PathVariable Long id) {

        return Workdayrepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
    }
    @PutMapping("/workdays/{id}")
    Workday replaceWorkday(@RequestBody Workday newWorkday, @PathVariable Long id) {

        return Workdayrepository.findById(id)
                .map(workday -> {
                    workday.setDate(newWorkday.getDate());
                    return Workdayrepository.save(workday);
                })
                .orElseGet(() -> {
                    newWorkday.setId(id);
                    return Workdayrepository.save(newWorkday);
                });
    }
    @DeleteMapping("/workdays/{id}")
    void deleteWorkday(@PathVariable Long id) {
        Workdayrepository.deleteById(id);
    }


}