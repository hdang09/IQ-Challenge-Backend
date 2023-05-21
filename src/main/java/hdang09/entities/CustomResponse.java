/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

/**
 *
 * @author Admin
 */
public class CustomResponse {

    private boolean success;
    private String message;
    private Data data;

    public CustomResponse() {
    }

    public CustomResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CustomResponse(boolean success, String message, Data data) {
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
