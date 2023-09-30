package com.olp.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtitlity {

    public static boolean passwordComparator(String loginPassword,String dbPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(loginPassword,dbPassword);
    }

    public static String hashPassword(String rawPassword){
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}
