//package com.example.restfulwebservices.exception;
//
//import com.example.restfulwebservices.user.UserNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.rmi.server.ExportException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class CustomizedResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
//
//        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//    @ExceptionHandler(UserNotFoundException.class)
//    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
//
//        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
//
//    }
//
//
//}
