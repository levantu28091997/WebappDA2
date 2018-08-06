package dev.entity;

public class BaseRespone {
    private String data;
    private String message;

    public BaseRespone(String data, String message) {
        this.data = data;
        this.message = message;
    }

    public BaseRespone(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
