package com.example.demo.Converter;

import com.example.demo.Point.Points;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PointsConverter implements Converter{
    ObjectMapper mapper = new ObjectMapper();
    List<Points> pointsList;

    @Override
    public void convert() {
            try {
                pointsList = Arrays.asList(mapper.readValue(new File("src/main/java/com/example/demo/Json/locations.json"), Points[].class) );
            } catch (IOException e) {
                e.printStackTrace();
            }



    }
    public List<Points> getPointsList() {
        return pointsList;
    }
}
