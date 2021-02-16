package com.example.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;


import java.util.*;

@Service
public class URLShortnerService {

    @Autowired
    private URLShortnerRepo urlShortnerRepo;
    private URLShortnerModule urlShortnerModule;


    public String getLongURL(String short_url_check) {
        List<URLShortnerModule> urlShortnerModuleList = new ArrayList<>();
//        System.out.println("Reached here");
        System.out.println(short_url_check);
        Optional<URLShortnerModule> longURL= urlShortnerRepo.findByLong_url(short_url_check);
        System.out.println(longURL.get().getLong_url());
        return (longURL.get().getLong_url());
    }

    public String getShortURL(URL url) {
        String token = createToken();
        String short_url =token;
        URLShortnerModule urlShortnerModule=new URLShortnerModule();
        urlShortnerModule.setShort_url(short_url);
        urlShortnerModule.setLong_url(url.getLong_url());
//        urlShortnerModule.setUrl_created_on(url);
//        urlShortnerModule.setUrl_created_on(url.getCreated_on());
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        System.out.println("Current Time Stamp: "+ts);
        System.out.println(token+"    "+short_url);
        urlShortnerModule.setUrl_created_on(ts);
        urlShortnerRepo.save(urlShortnerModule);
        return (token);
    }
    public String createToken(){

//        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
//        String numbers = "1234567890";
//        String combinedChars = capitalCaseLetters + lowerCaseLetters + numbers;
//        Random random = new Random();
//        char[] password = new char[7];
//
//        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
//        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
////        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
//        password[3] = numbers.charAt(random.nextInt(numbers.length()));
//
//        for(int i = 5; i< 7 ; i++) {
//            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
//        }
//        return password;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 7, characters );
        System.out.println( pwd );
        return pwd;
    }
}
