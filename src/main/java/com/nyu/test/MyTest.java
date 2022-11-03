package com.nyu.test;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        System.out.println(weatherStation("all"));
    }

    public static List<String> weatherStation(String keyword) {
        String mainUrl = "https://jsonmock.hackerrank.com/api/weather/search?name=";
        String wholeUrl = mainUrl + keyword;
        List<String> result = new ArrayList<>();

        try {
            URL url = new URL(wholeUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getPhoneNumbers(String country, String phoneNumber) throws IOException {
        String main = "https://jsonmock.hackerrank.com/api/countries?name=";
        String urlStr = main + country;
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        String result = "-1";

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            JSONObject obj = new JSONObject(content.toString());
            JSONArray arr = obj.getJSONArray("data");
            if (arr.length() != 0) {
                JSONObject data = arr.getJSONObject(0);
                String numericCode = (String) data.get("numericCode");
                result = "+" + numericCode + " " + phoneNumber;
            }
        }
        return result;
    }
}
