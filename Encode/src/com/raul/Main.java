package com.raul;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String original = "The string Ü@doo-bar";
        System.out.println(original);
        String encode = URLEncoder.encode(original, StandardCharsets.UTF_8.toString());
        System.out.println(encode);


    }
}
