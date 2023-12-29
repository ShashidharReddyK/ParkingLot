package com.myProject.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ObjectContainer {
    private Map<String, Object> objectsMap = new HashMap<>();
    public void register(String str, Object obj){
        objectsMap.put(str,obj);
    }

    public Object get(String key){
        return objectsMap.getOrDefault(key,null);
    }


}
