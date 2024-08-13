package ir.bookstore.controller;

import ir.bookstore.dto.response.ExceptionResponse;
import ir.bookstore.exception.RuleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RuleException.class)
    public ResponseEntity<List<ExceptionResponse>> handleRuleException(RuleException ruleException){
        return  ResponseEntity
                    .status(400)
                    .body(Collections.singletonList(getBuild(ruleException)));
    }

    private  ExceptionResponse getBuild(RuleException ruleException) {
        return ExceptionResponse.builder()
                .message(ruleException.getMessage())
                .code(ruleException.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.status(402)
                .body(MethodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));
    }

    private List<ExceptionResponse> MethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
       return   methodArgumentNotValidException.getFieldErrors().stream().map(
                 error->ExceptionResponse
                         .builder()
                         .message(error.getDefaultMessage())
                         .code(error.getField())
                         .build()
         ).collect(Collectors.toList());

    }
}
