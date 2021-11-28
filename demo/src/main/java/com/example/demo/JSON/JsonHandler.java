package com.example.demo.JSON;

import com.example.demo.Location.City;
import com.example.demo.Location.FirstPoint;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class JsonHandler {
    ObjectMapper mapper = new ObjectMapper();
    List<City> cities;
    FirstPoint firstPoint;
    {
        try {
            cities = Arrays.asList(mapper.readValue(new File("locations.json"), City[].class) );
            firstPoint = mapper.readValue(new File("startPoint.json"), FirstPoint.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<City> getCities(){
        return cities;
    }
    public FirstPoint getStartPoint(){
        return firstPoint;
    }
}