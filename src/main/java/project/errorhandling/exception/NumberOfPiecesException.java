package project.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NumberOfPiecesException extends RuntimeException {

    public NumberOfPiecesException() {
        super("The number of pieces should be positive");
    }

}
