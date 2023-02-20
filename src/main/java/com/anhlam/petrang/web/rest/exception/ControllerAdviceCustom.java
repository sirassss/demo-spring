package com.anhlam.petrang.web.rest.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class ControllerAdviceCustom {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleLogin(AuthenticationException exception, NativeWebRequest request) {
        String err = "";
        if (exception instanceof BadCredentialsException) {
            err = "Thông tin đăng nhập không đúng";
        } else if (exception instanceof AccountExpiredException){
            err = "Tài khoản đã hết hạn";
        } else if (exception instanceof CredentialsExpiredException) {
            err = "Thông tin đăng nhập của người dùng đã hết hạn";
        } else if (exception instanceof LockedException) {
            err = "Tài khoản đã bị khóa";
        } else if (exception instanceof DisabledException) {
            err = "Tài khoản đã tắt";
        }
        return ResponseEntity.ok(err);
    }
}
