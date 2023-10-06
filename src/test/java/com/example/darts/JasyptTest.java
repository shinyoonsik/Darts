package com.example.darts;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Test
    void jasyptTest(){
        // password뿐만 아니라 database-url, username도 숨기고 싶다면 아래와 같이 변수를 만들어서 할당하면 된다
        // String databaseUrl = "jdbc:mysql://localhost:3306/security?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
        String password = "1234";
        String result = jasyptEncoding(password);

        System.out.println("===========");
        System.out.println(result);
        System.out.println("===========");
    }

    private String jasyptEncoding(String password){
        String key = "cNqBamd2ZIPka7wRoM8UcTXEEkhBMW6E";
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setAlgorithm("PBEWITHMD5ANDDES");
        standardPBEStringEncryptor.setPassword(key);

        return standardPBEStringEncryptor.encrypt(password);
    }
}
