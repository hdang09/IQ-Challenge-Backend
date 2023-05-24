/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import hdang09.entities.data.QuestionData;

/**
 *
 * @author Admin
 * @param <T>
 */
public class CustomResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public CustomResponse() {
    }

    public CustomResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CustomResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
