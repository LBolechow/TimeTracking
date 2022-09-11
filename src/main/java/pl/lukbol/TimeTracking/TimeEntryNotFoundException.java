package pl.lukbol.TimeTracking;

public class TimeEntryNotFoundException extends RuntimeException{

    TimeEntryNotFoundException(Long id) {
        super("Brak TimeEntry o id: " + id);
    }
}
