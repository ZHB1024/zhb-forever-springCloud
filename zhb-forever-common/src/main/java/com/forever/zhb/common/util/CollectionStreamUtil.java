package com.forever.zhb.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionStreamUtil {
    
    
    public static void main(String[] args) {
        List<String> listString = CollectionUtil.getListString();
        
        List<String> result = listString.stream().map(key -> {
            return key;
        }).collect(Collectors.toList());
        
        result.parallelStream().forEach(key -> {
            pring(key);
        } );
    }
    
    private static class CollectionUtil{
        public static List<String> getListString(){
            List<String> result = new ArrayList<String>();
            result.add("1");
            result.add("2");
            result.add("3");
            result.add("4");
            result.add("5");
            result.add("6");
            return result;
        }
    }
    
    
    public static void pring(String value) {
        System.out.println(value);
    }
    

}
