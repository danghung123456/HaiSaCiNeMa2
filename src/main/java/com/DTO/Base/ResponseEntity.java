package com.DTO.Base;

/**
 * @author Minh Hung
 * the custom Response Entity API
 * Use for common return model
 * @param <T> the generic Type of the response
 */
public class ResponseEntity<T>{

    private T data;

    public T getData() {
        return data;
    }

    public ResponseEntity(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseEntity<T> body(T body) {
        return new ResponseEntity<>(body);
    }
    

}
