package it.esame.POproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.esame.POproject.data.Tweet;



public class Downloader {
	
	


public JSONObject DownloadToFile () {

	
String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=farenz&count=100"; 
	
	try {
		
		URLConnection openConnection = new URL(url).openConnection();
		InputStream in = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inR = new InputStreamReader( in );
		   BufferedReader buf = new BufferedReader( inR );
		  
		   while ( ( line = buf.readLine() ) != null ) {
			   data+= line;
		   }
		 } finally {
		   in.close();
		 }
		
		 
		JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
		
		return obj;
	
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
	
  }






public void Serializzazione (JSONObject obj, int counter) {

	
JSONArray obj2 = (JSONArray) (obj.get("statuses"));
ArrayList <Tweet> tweets = new ArrayList <Tweet>(100); 


for(int i=0; i<100; i++) {
	Tweet x = new Tweet();
	tweets.add(x);
}

//System.out.println(tweets.size());

    

for(Object var : obj2) {
	
	
	if ( var instanceof JSONObject) {
		
	JSONObject obj4 = (JSONObject) var;
	SingolaSerializzazione (obj4, tweets.get(counter));
	//System.out.println(tweets.get(counter).created_at);
	counter++;
	} 
		
    	
}	
	
	
	
	
	
  }






		

public void SingolaSerializzazione (JSONObject var, Tweet t) {

t.created_at = (String) (var.get("created_at"));
//System.out.println(t.created_at);
}




}
