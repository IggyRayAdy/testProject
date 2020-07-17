package com.test.application.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResEntity {
    public static ResponseEntity<Object> createResponseEntity(Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", responseObject);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
