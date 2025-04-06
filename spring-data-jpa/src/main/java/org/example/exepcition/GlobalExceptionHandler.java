package org.example.exepcition;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Date;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, List<String>> errorsMap = new HashMap();
        for (ObjectError objError : ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) objError).getField();
            if( errorsMap.containsKey(fieldName)){
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
//                errorsMap.get(fieldName).add(objError.getDefaultMessage());
            } else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
//                List<String> list = new ArrayList<>();
//                list.add(objError.getDefaultMessage());
//                errorsMap.put(fieldName, list);
            }
        }
        //return ResponseEntity.badRequest().body(createApiError("fdjvdfjvfd"));
        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private <T> ApiError<T> createApiError(T errors){
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date(System.currentTimeMillis()));
        apiError.setErrors(errors);

        return apiError;
    }
}
