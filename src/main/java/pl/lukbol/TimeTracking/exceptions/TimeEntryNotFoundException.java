package pl.lukbol.TimeTracking.exceptions;

public class TimeEntryNotFoundException extends RuntimeException{

    TimeEntryNotFoundException(Long id) {
        super("Brak TimeEntry o id: " + id);
    }
}
