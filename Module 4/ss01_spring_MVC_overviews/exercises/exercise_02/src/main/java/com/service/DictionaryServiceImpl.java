package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceImpl implements IDictionaryServices{

    @Override
    public String translate(String text) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin Chao");
        dictionary.put("how", "The Nao");
        dictionary.put("book", "Quyen Vo");
        dictionary.put("computer", "May Tinh");
        String result = dictionary.get(text);
        String noFind="Not found!";
        if(result != null){
            return result;
        } else {
            return noFind;
        }
    }
}
