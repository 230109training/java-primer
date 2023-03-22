package com.revature.dto;

import java.util.Objects;

public class LoginSuccessDTO {

    private String message;
    private String token;

    public LoginSuccessDTO() {
    }

    public LoginSuccessDTO(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginSuccessDTO that = (LoginSuccessDTO) o;
        return Objects.equals(message, that.message) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, token);
    }

    @Override
    public String toString() {
        return "LoginSuccessDTO{" +
                "message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
