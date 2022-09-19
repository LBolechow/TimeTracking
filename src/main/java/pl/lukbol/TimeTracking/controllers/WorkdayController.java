package pl.lukbol.TimeTracking.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukbol.TimeTracking.service.WorkdayService;
import pl.lukbol.TimeTracking.models.Workday;


import java.util.List;

@RestController
public class WorkdayController {

    @Autowired
  private WorkdayService workdayService;


    @GetMapping("/workdays")
    List<Workday> displayAll() {
        return workdayService.displayAll();
    }

    @PostMapping("/workdays")
    Workday AddNewWorkday(@RequestBody Workday newWorkday) {
        return workdayService.AddNewWorkday(newWorkday);
    }

    @GetMapping("/workdays/{id}")
    Workday GetWorkdayById(@PathVariable Long id) {return workdayService.GetWorkdayById(id);}

    @PutMapping("/workdays/{id}")
    Workday ReplaceWorkdayById(@RequestBody Workday newWorkday, @PathVariable Long id) {return workdayService.ReplaceWorkdayById(newWorkday, id);}

    @DeleteMapping("/workdays/{id}") void DeleteWorkdayById(@PathVariable Long id) { workdayService.DeleteWorkdayById(id);}


}
