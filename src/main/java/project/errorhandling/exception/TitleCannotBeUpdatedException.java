package project.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TitleCannotBeUpdatedException extends RuntimeException {

    public TitleCannotBeUpdatedException() {
        super("The title cannot be updated");
    }

}
