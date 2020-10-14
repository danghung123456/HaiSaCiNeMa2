package com.DTO.Base;

/**
 * @author Minh Hung
 * the custom Response Entity API
 * Use for common return model
 * @param <T> the generic Type of the response
 */
public class ResponseEntiy<T>{

    private T data;

    public T getData() {
        return data;
    }

    public ResponseEntiy(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseEntiy<T> body(T body) {
        return new ResponseEntiy<>(body);
    }

}
