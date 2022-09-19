package pl.lukbol.TimeTracking.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.lukbol.TimeTracking.exceptions.WorkdayNotFoundException;
import pl.lukbol.TimeTracking.models.Workday;
import pl.lukbol.TimeTracking.repositories.TimeEntryRepository;
import pl.lukbol.TimeTracking.repositories.WorkdayRepository;

import java.util.List;
@Service
public class WorkdayService {


    public final WorkdayRepository workdayRepository;
    public final TimeEntryRepository entryRepository;

    WorkdayService(WorkdayRepository workdayRepository, TimeEntryRepository entryRepository) {
        this.workdayRepository = workdayRepository;
        this.entryRepository = entryRepository;
    }
    public List<Workday> displayAll() {
        return workdayRepository.findAll();
    }

    public Workday AddNewWorkday(@RequestBody Workday newWorkday) {
        return workdayRepository.save(newWorkday);
    }

    public  Workday GetWorkdayById(@PathVariable Long id) {

        return workdayRepository.findById(id)
                .orElseThrow(() -> new WorkdayNotFoundException(id));
    }
    public Workday ReplaceWorkdayById(@RequestBody Workday newWorkday, @PathVariable Long id) {

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
     public void DeleteWorkdayById(@PathVariable Long id) {
        workdayRepository.deleteById(id);
    }
}
