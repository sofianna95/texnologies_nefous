package project.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DVDAlreadyExistsException extends RuntimeException {

    public DVDAlreadyExistsException(String title) {
        super(String.format("DVD with title %s already exists", title));
    }

}
