package pl.lukbol.TimeTracking;

public class WorkdayNotFoundException extends RuntimeException {
    public WorkdayNotFoundException(Long id) {
        super("Brak Workday o id:  " + id);
    }
}
