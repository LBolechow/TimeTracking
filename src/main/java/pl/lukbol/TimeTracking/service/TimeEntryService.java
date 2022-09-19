package pl.lukbol.TimeTracking.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.lukbol.TimeTracking.exceptions.WorkdayNotFoundException;
import pl.lukbol.TimeTracking.models.TimeEntry;
import pl.lukbol.TimeTracking.models.Workday;
import pl.lukbol.TimeTracking.repositories.TimeEntryRepository;
import pl.lukbol.TimeTracking.repositories.WorkdayRepository;

import java.util.List;

@Service
public class TimeEntryService {

    public final WorkdayRepository workdayRepository;
    public final TimeEntryRepository entryRepository;

    TimeEntryService(WorkdayRepository workdayRepository, TimeEntryRepository entryRepository) {
        this.workdayRepository = workdayRepository;
        this.entryRepository = entryRepository;
    }

public List<TimeEntry> getEntries(@PathVariable Long id)
{
    Workday workDay = workdayRepository.findById(id) //
            .orElseThrow(() -> new WorkdayNotFoundException(id));
    return  workDay.getTimeEntry();
}
public void postEntries(@RequestBody TimeEntry entry, @PathVariable Long id)
{
    Workday workDay = workdayRepository.findById(id)
            .orElseThrow(() -> new WorkdayNotFoundException(id));
    TimeEntry timeEntry = new TimeEntry(entry.opis, entry.czas);
    timeEntry.setWorkday(workDay);
    workDay.getTimeEntry().add(timeEntry);
    workdayRepository.save(workDay);
}

}
