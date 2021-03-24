package com.bank.controller.exhandler;

import com.bank.exceptions.account.AccountException;
import com.bank.exceptions.client.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountException.class)
    protected ResponseEntity<String> handleAccountException(AccountException ex) {
        return new ResponseEntity<>("error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientException.class)
    protected ResponseEntity<String> handleClientException(ClientException ex) {
        return new ResponseEntity<>("error " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
