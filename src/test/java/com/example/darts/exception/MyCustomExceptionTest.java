package com.example.darts.exception;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    @Disabled
    @Test
    @DisplayName("Checked Exception 테스트")
    void testCheckedException() throws FileNotFoundException {
        FileReader fileReader = new FileReader("sample.txt");
        try {
            fileReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // try-resource는 AutoCloseable인터페이스를 구현한 애들만 사용할 수 있음
        // 자동으로 close해주므로 finally필요없다
        try(FileReader fileReader2 = new FileReader("sample.txt")){
            fileReader2.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}