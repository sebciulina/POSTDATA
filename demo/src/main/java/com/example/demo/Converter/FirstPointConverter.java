package com.example.demo.Converter;

import com.example.demo.Point.FirstPoint;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FirstPointConverter implements Converter{
    ObjectMapper mapper = new ObjectMapper();
    FirstPoint firstPoint;

    @Override
    public void convert() {
        try {
            firstPoint = mapper.readValue(new File("src/main/java/com/example/demo/Json/startPoint.json"), FirstPoint.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FirstPoint getStartPoint(){
        return firstPoint;
    }
}

