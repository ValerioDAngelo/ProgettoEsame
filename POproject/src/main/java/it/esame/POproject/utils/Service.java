package it.esame.POproject.utils;

import java.util.ArrayList;

import it.esame.POproject.data.Metadata;
import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.statistics.time_stats;
import it.esame.POproject.statistics.day_stats;
import java.lang.reflect.*;
import java.util.regex.Pattern;





public class Service {

	static ArrayList<Tweet> array;
	

	
	public static ArrayList<Tweet> getArray() {
			return array;
		}



	public static void setArray (ArrayList<Tweet> array) {
			Service.array = array;
		}



	
	
	
	public static ArrayList<Metadata> getMetadata ()	{
		
	ArrayList<Metadata> metadata = new ArrayList<Metadata> ();	
	Class<?>  myClass = Tweet.class;
	Field[] fields = myClass.getFields();
	
	for (Field field : fields) {
		
		Metadata metadata1 = new Metadata ();
		metadata1.setField_name(field.getName());
		metadata1.setField_type(field.getType().getSimpleName());
		metadata.add(metadata1);
		}

	return metadata;
	}
	
	

	
	
	public static CompleteStats getTimeStats () { 
		
	ArrayList<Tweet> array = new ArrayList<Tweet> ();
	ArrayList<String> times_AM = new ArrayList<String> ();
	ArrayList<String> times_PM = new ArrayList<String> ();
	CompleteStats stats = new CompleteStats ();
	array = Service.array;
	String[] time1 = null;
	String[] time2 = null;
	time_stats time_stats_AM = new time_stats ();
	time_stats time_stats_PM = new time_stats ();

	for(Tweet t : array) { 

	Pattern pattern1 = Pattern.compile("\\s");
	Pattern pattern2 = Pattern.compile("\\W");
	time1 = pattern1.split(t.created_at);
	time2 = pattern2.split(time1[3]);
	int time3 = Integer.parseInt (time2[0]);
	if (time3 < 13) {
	
	times_AM.add(time1[3]);
	}
	else {
		
	times_PM.add(time1[3]);
	}

	}

	time_stats_AM.CalcTimeStats (times_AM);
	time_stats_PM.CalcTimeStats (times_PM);
	
	stats.setMin_AM(time_stats_AM.getMin());
	stats.setMax_AM(time_stats_AM.getMax());
	stats.setAvg_AM(time_stats_AM.getAvg());
	stats.setDevst_AM(time_stats_AM.getDevst());
	stats.setMin_PM(time_stats_PM.getMin());
	stats.setMax_PM(time_stats_PM.getMax());
	stats.setAvg_PM(time_stats_PM.getAvg());
	stats.setDevst_PM(time_stats_PM.getDevst());
	
	return stats;	
		
	}	


	
	
	
	


    public static day_stats getDayStats () {
		
	ArrayList<Tweet> array = new ArrayList<Tweet> ();
	array = Service.array;
	day_stats dayStats = new day_stats ();

	
	dayStats.CalcdayStats (array);


	return dayStats;	
		
	}	
	

}
