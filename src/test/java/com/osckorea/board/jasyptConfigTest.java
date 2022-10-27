//package com.osckorea.board;
//
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class jasyptConfigTest {
//
//    @Test
//    void stringEncryptor() {
//    }
//
//    @Test
//    void jasypt() {

//        System.out.println(jasyptEncoding(url));
//        System.out.println("-----------------------------------");
//        System.out.println(jasyptEncoding(username));
//        System.out.println("-----------------------------------");
//        System.out.println(jasyptEncoding(password));
//        System.out.println("-----------------------------------");
//    }
//
//    public String jasyptEncoding(String value) {
//
//        String key = "my_jasypt_key";
//        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
//        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
//        pbeEnc.setPassword(key);
//        return pbeEnc.encrypt(value);
//    }
//}
