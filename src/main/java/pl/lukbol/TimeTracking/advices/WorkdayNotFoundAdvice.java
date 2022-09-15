package pl.lukbol.TimeTracking.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.lukbol.TimeTracking.exceptions.WorkdayNotFoundException;

@ControllerAdvice
public class WorkdayNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WorkdayNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(WorkdayNotFoundException ex) {
        return ex.getMessage();
    }
}
