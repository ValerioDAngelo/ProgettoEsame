package it.esame.POproject.utils;

import java.util.ArrayList;

import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.data.time_stats;
import it.esame.POproject.statistics.day_stats;

import java.util.regex.Pattern;





public class test {

	static ArrayList<Tweet> array;
	

	
	public static ArrayList<Tweet> getArray() {
			return array;
		}



	public static void setArray (ArrayList<Tweet> array) {
			test.array = array;
		}

	
	
		
	public static CompleteStats getTimeStats () { 
		
	ArrayList<Tweet> array = new ArrayList<Tweet> ();
	ArrayList<String> times_AM = new ArrayList<String> ();
	ArrayList<String> times_PM = new ArrayList<String> ();
	CompleteStats stats = new CompleteStats ();
	array = test.array;
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
	ArrayList<Tweet> Statsarray_1w = new ArrayList<Tweet> ();
	ArrayList<Tweet> Statsarray_2w = new ArrayList<Tweet> ();
	ArrayList<Tweet> Statsarray_3w = new ArrayList<Tweet> ();
	ArrayList<Tweet> Statsarray_4w = new ArrayList<Tweet> ();
	array = test.array;
	String[] day1 = null;
	int number_month;
	day_stats dayStats = new day_stats ();


	for(Tweet t : array) {

	Pattern pattern = Pattern.compile("\\s");
	day1 = pattern.split(t.created_at);
	number_month = Integer.parseInt(day1[2]);
	
	
	if (day1[1].equals("Jun")) {

	
	if (number_month <= 7)  Statsarray_1w.add(t);
	if (number_month > 7 && number_month <= 14)  Statsarray_2w.add(t);
	if (number_month > 14 && number_month <= 21)  Statsarray_3w.add(t); 
	if (number_month > 21 && number_month <= 28)  Statsarray_4w.add(t);

	}

	}

	day_stats.CalcDayStats (Statsarray_1w, Statsarray_2w, Statsarray_3w, Statsarray_4w);


	return dayStats;	
		
	}	
	

}
