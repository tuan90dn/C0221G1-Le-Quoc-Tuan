package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceImpl implements IDictionaryServices{

    @Override
    public String translate(String text) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin Chào");
        dictionary.put("how", "Thế Nào");
        dictionary.put("book", "Quyển Vở");
        dictionary.put("computer", "Máy Tính");
        String result = dictionary.get(text);
        String noFind="Not found!";
        if(result != null){
            return result;
        } else {
            return noFind;
        }
    }
}
