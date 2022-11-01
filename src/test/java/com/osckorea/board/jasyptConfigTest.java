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
//            String url = "jdbc:mysql://ec2-3-38-111-117.ap-northeast-2.compute.amazonaws.com:3306/oscboard?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
//                String username = "root";
//                String password = "1q2w3e4r";
//                }

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
