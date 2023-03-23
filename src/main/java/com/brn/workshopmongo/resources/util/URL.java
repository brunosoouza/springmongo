package com.brn.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


//classe responsavel por decodificar a URL, ou aplicar o %20
public class URL {
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
