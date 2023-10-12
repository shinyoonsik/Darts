package com.example.darts.aop;

import com.example.darts.domain.common.CommonResponse;
import com.example.darts.domain.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    // 잡고싶은 exception을 적어주면 된다.
    @ExceptionHandler({Exception.class, RuntimeException.class})
    CommonResponse catchException(HttpServletRequest request, Exception e){
        return CommonResponse.builder()
                .code("ER0001")
                .message(e.getMessage())
                .data(null)
                .description("error")
                .build();
    }

    @ExceptionHandler(CustomException.class)
    void setResponseOfCustomException(){
    }
}
