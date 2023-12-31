package academy.devdojo.springboot2.curso.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import academy.devdojo.springboot2.curso.exception.BadRequestException;
import academy.devdojo.springboot2.curso.exception.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExecptionHandler {
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestExecption(BadRequestException bre){
        return new ResponseEntity<>(
            BadRequestExceptionDetails.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .title("Bad Request Excpetion, Check the Documentation")
            .details(bre.getMessage())
            .developerMessage(bre.getClass().getName())
            .build(), HttpStatus.BAD_REQUEST);
        }
}
