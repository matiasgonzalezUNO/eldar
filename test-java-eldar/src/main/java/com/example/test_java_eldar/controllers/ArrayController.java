package com.example.test_java_eldar.controllers;

import com.example.test_java_eldar.services.arrayManager.ArrayUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array")
@Tag(name = "Array resource")
public class ArrayController {

    @Autowired
    ArrayUtil arrayUtil;

    @Operation(summary = "evaluate a array")
    @PostMapping("/refactor")
    public ResponseEntity<?> analyzeArray(@RequestBody String[] array) {
        try {
            return new ResponseEntity<>(arrayUtil.convertArray(array), HttpStatus.OK);
        }  catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
