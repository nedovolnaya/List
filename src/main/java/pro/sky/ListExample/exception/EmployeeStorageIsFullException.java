package pro.sky.ListExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Список переполнен");
    }

    public EmployeeStorageIsFullException(String message) {
    }

    public EmployeeStorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeStorageIsFullException(Throwable cause) {
        super(cause);
    }

    public EmployeeStorageIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
