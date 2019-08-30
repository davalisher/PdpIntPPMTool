package uz.pdp.ppmtool.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> MapValidationService(BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errorMessages = new HashMap<>();
            for (FieldError fieldError:result.getFieldErrors()) {
                errorMessages.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
