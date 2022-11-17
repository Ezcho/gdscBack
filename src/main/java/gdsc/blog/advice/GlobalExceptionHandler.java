package gdsc.blog.advice;

import gdsc.blog.dto.post.Error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class})
    protected ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("Item not found")
                .message(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


}
