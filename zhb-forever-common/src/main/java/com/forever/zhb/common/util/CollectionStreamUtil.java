package com.forever.zhb.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.forever.zhb.common.vo.KeyValueVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionStreamUtil {
    
    
    public static void main(String[] args) {
        List<KeyValueVO<String, Integer>> listKeyValueVOs = CollectionUtil.getListKeyValueVO();
        List<Pair> pairs = listKeyValueVOs.stream().map(vo -> {
            return Pair.of(vo.getKey(), vo.getValue());
        }).collect(Collectors.toList());
        
        //Map<String, Integer> maps = listKeyValueVOs.stream().collect(Collectors.toMap(KeyValueVO::getKey, KeyValueVO::getValue,(key1,key2)->key1));
        
        //Map<String, KeyValueVO> maps = listKeyValueVOs.stream().collect(Collectors.toMap(KeyValueVO::getKey, vo->vo,(key1,key2)->key1));
        
        Map<String, List<KeyValueVO<String, Integer>>> maps = listKeyValueVOs.stream().collect(Collectors.groupingBy(KeyValueVO::getKey));
        
        
        maps.forEach((key,value) -> {
            System.out.println(key + ":" + value);
        });
        
        /*
         * List<String> listString = CollectionUtil.getListString(); List<String> result
         * = listString.stream().map(key -> { return key;
         * }).collect(Collectors.toList()); result.parallelStream().forEach(key -> {
         * print(key); } );
         */
        
        
        
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
        
        public static List<KeyValueVO<String, Integer>> getListKeyValueVO(){
            List<KeyValueVO<String, Integer>> result = new ArrayList<KeyValueVO<String,Integer>>();
            result.add(new KeyValueVO<String, Integer>("1",1));
            result.add(new KeyValueVO<String, Integer>("1",2));
            result.add(new KeyValueVO<String, Integer>("1",3));
            result.add(new KeyValueVO<String, Integer>("2",2));
            result.add(new KeyValueVO<String, Integer>("3",3));
            result.add(new KeyValueVO<String, Integer>("4",4));
            result.add(new KeyValueVO<String, Integer>("5",5));
            return result;
        }
    }
    
    
    public static void print(String value) {
        System.out.println(value);
    }
    

}
