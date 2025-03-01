package com.example.productservice.Advice;

import com.example.productservice.DTO.ErrorDTO;
import com.example.productservice.Exception.ProductNotFoundException;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(){

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode("400");
        errorDTO.setErrorMsg("Bad Request");

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(){

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode("404");
        errorDTO.setErrorMsg("Product Not Found");

        return ResponseEntity.badRequest().body(errorDTO);
    }
}
