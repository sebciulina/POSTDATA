package com.example.demo.Main;

import com.example.demo.Converter.FirstPointConverter;
import com.example.demo.Converter.PointsConverter;
import com.example.demo.JsonReader;
import com.example.demo.Point.FirstPoint;
import com.example.demo.Point.Points;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        FirstPointConverter firstPointConverter = new FirstPointConverter();
        PointsConverter pointsConverter = new PointsConverter();
        pointsConverter.convert();
        firstPointConverter.convert();

        List<Points> wGdyni = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Gdynia")).toList();
        List<Points> wSopocie = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Sopot")).toList();
        List<Points> wGdansku = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Gdańsk")).toList();
        System.out.println(wGdyni);
        System.out.println(wSopocie);
        System.out.println(wGdansku);

        JsonReader reader = new JsonReader();
        String keyy = "tutaj podac key";

        //gdynia sopot najkrocej
        HashMap<Points, String> pointsHashMap = new HashMap<>();
        HashMap<Integer, HashMap<Points, String>> hashMap = new HashMap<>();
        int i = 1;
        FirstPoint firstPoint = firstPointConverter.getStartPoint();
        for (Points point : wSopocie) {
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination=" + firstPoint.getCity() + "+" + firstPoint.getStreet().replaceAll(" ", "") + "+" + firstPoint.getStreetNumber() + "&origin=" + point.getCity() + "+" + point.getStreet().replaceAll(" ", "") + "+" + point.getStreetNumber() + "&key="+keyy;
            System.out.println(path);
            JSONObject jsonObject = reader.readJsonFromUrl(path);
            pointsHashMap.put(point, jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            i++;
            System.out.println(i);
            System.out.println(jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            if (i == 51) {
                break;
            }


        }
        hashMap.put(1,pointsHashMap);
        System.out.println(hashMap.get(1));
        int j = 1;
        long l=9999;
        Points closeSopot = new Points();
        for (Points point:wSopocie){
            if (Long.parseLong(hashMap.get(1).get(point))<l){
                l = Long.parseLong(hashMap.get(j).get(point));
                System.out.println("wchodze");
                closeSopot = point;
            }
        }
        System.out.println(l);
        System.out.println(closeSopot);

        //sopot-gdansk najkrocej

        HashMap<Points,String> pointsHashMap1 = new HashMap<>();
        HashMap<Integer, HashMap<Points,String>> hashMap1 = new HashMap<>();
        int help = 1;
        Points firstPoint1 = closeSopot;
        for (Points point:wGdansku){
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination="+firstPoint1.getCity()+"+"+firstPoint1.getStreet().replaceAll(" ","")+"+"+firstPoint1.getStreetNumber()+"&origin="+point.getCity()+"+"+point.getStreet().replaceAll(" ","")+"+"+point.getStreetNumber()+"&key="+keyy;
            System.out.println(path);
            JSONObject jsonObject = reader.readJsonFromUrl(path);
            pointsHashMap1.put(point,jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            System.out.println("podałem");
            help++;
            System.out.println(help);
            System.out.println(jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            if (help==51){
                break;
            }
        }
        hashMap1.put(1,pointsHashMap1);
        System.out.println(hashMap1.get(1));
        int jj = 1;
        long ll=9999;
        Points closeGdansk = new Points();
        for (Points point:wGdansku){
            if (Long.parseLong(hashMap1.get(jj).get(point))<ll){
                ll = Long.parseLong(hashMap1.get(jj).get(point));
                closeGdansk = point;
                System.out.println("sss");
            }
        }
        System.out.println(ll);
        System.out.println(closeGdansk);

        //gdańsk-krótka gańsk długa
        HashMap<Points,String> pointsHashMap2 = new HashMap<>();
        HashMap<Integer, HashMap<Points,String>> hashMap2 = new HashMap<>();
        int help2 = 1;
        Points firstPoint2 = closeGdansk;
        for (Points point:wGdansku){
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination="+firstPoint2.getCity()+"+"+firstPoint2.getStreet().replaceAll(" ","")+"+"+firstPoint2.getStreetNumber()+"&origin="+point.getCity()+"+"+point.getStreet().replaceAll(" ","")+"+"+point.getStreetNumber()+"&key="+keyy;
            System.out.println(path);
            JSONObject jsonObject = reader.readJsonFromUrl(path);
            pointsHashMap2.put(point,jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            help2++;
            System.out.println(help2);
            System.out.println(jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());

            if (help2==51){
                break;
            }

        }
        hashMap2.put(1,pointsHashMap2);
        System.out.println(hashMap2.get(1));
        int jjj = 1;
        long lll=0;
        Points farGdansk = new Points();
        for (Points point:wGdansku){
            if (Long.parseLong(hashMap2.get(jjj).get(point))>lll){
                lll = Long.parseLong(hashMap2.get(jjj).get(point));
                farGdansk = point;
                System.out.println("sss");
            }
        }
        System.out.println(lll);
        System.out.println(farGdansk);


        //usuwanie niepotrzebnych punktow
        List<Points> newWSopocie = new ArrayList<>();

        for (Points point:wSopocie){
            System.out.println("1");
            if (!point.equals(firstPoint1)){
                newWSopocie.add(point);
                //System.out.println("dodano point "+point);
            }
            else {
                System.out.println("nie dodano "+point);
            }
        }
        System.out.println(newWSopocie);

        List<Points> newWGdansku = new ArrayList<>();
        for (Points point:wGdansku){
            System.out.println("1");
            if (!point.equals(firstPoint2)){
                newWGdansku.add(point);
                //System.out.println("dodano point "+point);
            }
            else {
                System.out.println("nie dodano "+point);
            }
        }
        System.out.println(newWGdansku);

        String asPointersToGdynia = "https://maps.googleapis.com/maps/api/directions/json?key="+keyy+"&origin=";;
        asPointersToGdynia = asPointersToGdynia+firstPoint.getCity()+"+"+firstPoint.getStreet().replaceAll(" ","")+"+"+firstPoint.getStreetNumber();
        asPointersToGdynia = asPointersToGdynia+"&destination="+closeSopot.getCity().replaceAll(" ","")+"+"+closeSopot.getStreet().replaceAll(" ","")+"+"+closeSopot.getStreetNumber()+"&waypoints=optimize:true";


        for (Points pointMinus:wGdyni) {
            asPointersToGdynia = asPointersToGdynia+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToGdynia);

        String asPointersToSopot = "https://maps.googleapis.com/maps/api/directions/json?key="+keyy+"&origin=";
        asPointersToSopot = asPointersToSopot+firstPoint1.getCity()+"+"+firstPoint1.getStreet().replaceAll(" ","")+"+"+firstPoint1.getStreetNumber();
        asPointersToSopot = asPointersToSopot+"&destination="+closeGdansk.getCity().replaceAll(" ","")+"+"+closeGdansk.getStreet().replaceAll(" ","")+"+"+closeGdansk.getStreetNumber()+"&waypoints=optimize:true";



        for (Points pointMinus:newWSopocie) {
            asPointersToSopot = asPointersToSopot+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToSopot);

        String asPointersToGdansk = "https://maps.googleapis.com/maps/api/directions/json?key="+keyy+"&origin=";
        asPointersToGdansk = asPointersToGdansk+firstPoint2.getCity()+"+"+firstPoint2.getStreet().replaceAll(" ","")+"+"+firstPoint2.getStreetNumber();
        asPointersToGdansk = asPointersToGdansk+"&destination="+farGdansk.getCity().replaceAll(" ","")+"+"+farGdansk.getStreet().replaceAll(" ","")+"+"+closeSopot.getStreetNumber()+"&waypoints=optimize:true";


        for (Points pointMinus:newWGdansku) {
            asPointersToGdansk = asPointersToGdansk+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToGdansk);


        //zostało tylko pobrać punkty i walnac z tego trase

        //trasa od gdyni do sopotu
        JSONObject jsonGdynia = reader.readJsonFromUrl(asPointersToGdynia);

        System.out.println("optimal from gdynia");
        System.out.println(jsonGdynia.getJSONArray("geocoded_waypoints").getJSONObject(0).getJSONArray("routes").getJSONObject(0).getJSONArray("waypoint_order"));

        //trasa z sopotu do gdanska

        JSONObject jsonSopot = reader.readJsonFromUrl(asPointersToGdansk);
        System.out.println("optimal from sopot");
        System.out.println(jsonSopot.getJSONArray("geocoded_waypoints").getJSONObject(0).getJSONArray("routes").getJSONObject(0).getJSONArray("waypoint_order"));

        //trasa po gdansku
        JSONObject jsonGdansk = reader.readJsonFromUrl(asPointersToGdynia);
        System.out.println("optimal from gdansk");
        System.out.println(jsonGdansk.getJSONArray("geocoded_waypoints").getJSONObject(0).getJSONArray("routes").getJSONObject(0).getJSONArray("waypoint_order"));
    }
}






