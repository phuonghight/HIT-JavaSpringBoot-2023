package com.example.shopmanagerment.utils;

import com.example.shopmanagerment.exception.InvalidException;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    public static void propValidator(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg = "";

            for(String key: errors.keySet()){
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }

            throw new InvalidException(errorMsg);
        }
    }
}
