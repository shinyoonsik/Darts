package com.example.darts.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyCustomException extends RuntimeException{
    public MyCustomException(String message){
        super(message);
    }

    /**
     * cause는 MyCustomException이 발생한 구체적인 원인을 의미함
     * @param cause
     */
    public MyCustomException(Throwable cause){
        super(cause);
    }

    /**
     * message는 예외가 발생한 상황을 기술할 것
     * cause는 MyCustomException이 발생한 구체적인 원인
     * ex)
     *
     * @param message
     * @param cause
     */
    public MyCustomException(String message, Throwable cause){
        super(message, cause);
    }
}
