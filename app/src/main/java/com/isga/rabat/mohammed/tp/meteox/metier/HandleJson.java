package com.isga.rabat.mohammed.tp.meteox.metier;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HandleJson {
    private String pays;
    private Double temperature;
    private String humidite;
    private String pression;
    private String etat;
    private String vent;
    public static boolean fetched=false;
    private String urlString=null;
    public boolean finPersing=true;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = (temperature-273.15);
    }

    public String getHumidite() {
        return humidite;
    }

    public void setHumidite(String humidite) {
        this.humidite = humidite;
    }

    public String getPression() {
        return pression;
    }

    public void setPression(String pression) {
        this.pression = pression;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public HandleJson(String url){

        this.urlString=url;
    }

    public void lectureParseJSON(String in){
        try{
            JSONObject reader=new JSONObject(in);
            JSONObject weather=reader.getJSONArray("weather").getJSONObject(0);
            etat=weather.getString("description");
            JSONObject sys= reader.getJSONObject("sys");
            //pays=sys.getString("country");
            JSONObject main=reader.getJSONObject("main");
            setTemperature(Double.parseDouble(main.getString("temp")));
            //humidite=main.getString("humidity");
            pression=main.getString("pressure");
            JSONObject wind=reader.getJSONObject("wind");
            vent=wind.getString("speed");
            finPersing=false;


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static String conversionstreamToString(InputStream is){
        Scanner s=new Scanner(is).useDelimiter("\\A");
        return s.hasNext()? s.next():"";
    }

    public void fetchJSON(){
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //fetched=false;
                    String data=null;
                    URL url=new URL(urlString);
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream str= conn.getInputStream();
                    data=conversionstreamToString(str);
                    lectureParseJSON(data);
                    str.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
            th.start();

    }
}
