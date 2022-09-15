package pl.lukbol.TimeTracking.exceptions;

public class WorkdayNotFoundException extends RuntimeException {
    public WorkdayNotFoundException(Long id) {
        super("Brak Workday o id:  " + id);
    }
}
