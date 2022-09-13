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
    Workday replaceEmployee(@RequestBody Workday newEmployee, @PathVariable Long id) {

        return Workdayrepository.findById(id)
                .map(employee -> {
                    employee.setDate(newEmployee.getDate());
                    return Workdayrepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return Workdayrepository.save(newEmployee);
                });
    }
    @DeleteMapping("/workdays/{id}")
    void deleteWorkday(@PathVariable Long id) {
        Workdayrepository.deleteById(id);
    }


}
