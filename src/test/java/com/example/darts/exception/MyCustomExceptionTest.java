package com.example.darts.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyCustomExceptionTest {

    @Test
    @DisplayName("MyCustomException테스트 with message")
    void testMyCustomException() {
        // given
        MyCustomException myCustomException = new MyCustomException("입력값이 10보다 큽니다.");

        // when
        assertThrows(MyCustomException.class, () -> {throw myCustomException;});

        // then
        assertThat(myCustomException.getMessage()).isEqualTo("입력값이 10보다 큽니다.");
        assertThat(myCustomException.getCause()).isEqualTo(null);
    }

    @Test
    @DisplayName("MyCustomException테스트 with cause")
    void testMyCustomExceptionWithCause() {
        // given
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("입력값 info");
        MyCustomException myCustomException = new MyCustomException(illegalArgumentException);

        // when
        assertThrows(MyCustomException.class, () -> { throw myCustomException;});

        // then
        assertThat(myCustomException.getCause()).isEqualTo(illegalArgumentException);

    }

    @Test
    @DisplayName("MyCustomException테스트 with message, cause")
    void testMyCustomExceptionWithMessageAndCause() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("매개변수 a < 0[예외가 발생한 구체적인 정보: 매개변수 정보]");
        MyCustomException myCustomException = assertThrows(MyCustomException.class,
                () -> {
                    throw new MyCustomException("입력값이 10보다 큽니다.[예외 발생 상황 설명]"
                            , illegalArgumentException);
                });

        assertThat(myCustomException.getCause()).isEqualTo(illegalArgumentException);
    }
}