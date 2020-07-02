package it.esame.POproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONObject;

import it.esame.POproject.utils.Downloader;

@SpringBootApplication
public class POprojectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(POprojectApplication.class, args);
		Downloader d = new Downloader ();
		JSONObject obj2 = new JSONObject();
		obj2 = d.DownloadToFile();
		d.Serializzazione(obj2, 0);
		
	}

}
