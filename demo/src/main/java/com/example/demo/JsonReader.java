package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {
    int i = 0;

    private  String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public  JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            System.out.println("Request iterations =" + i);
            i++;
            return json;
        } finally {
            is.close();
        }
    }

    //public static void main(String[] args) throws IOException, JSONException {
    //    JSONObject json = readJsonFromUrl("https://jsonplaceholder.typicode.com/todos/1");
    //    System.out.println(json.toString());
    //    System.out.println("printuj wartosc pod title");
    //    System.out.println(json.get("title"));
   // }
}